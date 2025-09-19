package com.jacodplus.ImageApplication.Services;

import com.jacodplus.ImageApplication.Constants;
import com.jacodplus.ImageApplication.Exceptions.ResourceNotFoundException;
import com.jacodplus.ImageApplication.Models.*;
import com.jacodplus.ImageApplication.Connectors.IRepositories.IAPIConnector;
import com.jacodplus.ImageApplication.Models.Error;
import com.jacodplus.ImageApplication.Services.IServices.IImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServices implements IImageServices {
    @Autowired
    private IAPIConnector _imageRepository;
    @Override
    public ImageResponse fetchImages(ImageRequest imageRequest) {
        ImageResponse imageResponse = null;
        try {
            var response = _imageRepository.getResource(imageRequest.basePath+imageRequest.sourcePath);
            var imageResponseData = response.getData()
                    .getBrandGridByPath()
                    .getItem()
                    .getBrands()
                    .stream()
                    .map(ApiResponse.Brand::getBrandImage)
                    .toList();

            if (!imageResponseData.isEmpty()) {
                List<String> resourcePaths = imageResponseData.stream()
                        .map(ApiResponse.BrandImage::get_path)
                        .collect(Collectors.toList());
                imageResponse = new ImageResponse(resourcePaths, null);
            }
            else {
                imageResponse = new ImageResponse(null, new Error(1000, Constants.resourceNotFound));
            }
        }catch(ResourceNotFoundException rnfex){
            imageResponse = new ImageResponse(null, new Error(1000, rnfex.getMessage()));
        }
        catch(Exception ex){
            imageResponse = new ImageResponse(null, new Error(1001, Constants.badRequest));
        }
        finally{
            return imageResponse;
        }

    }
    @Override
    public ImageDataResponse fetchImage(ImageDataRequest imageDataRequest) {
        ImageDataResponse imageDataResponse = null;
        try {
            var response = _imageRepository.getResourceData(imageDataRequest.path);
            if (response!=null) {
                imageDataResponse = new ImageDataResponse(response, null);
            }
        }catch(ResourceNotFoundException rnfex){
            imageDataResponse = new ImageDataResponse(null, new Error(1000, rnfex.getMessage()));
        }
        catch(Exception ex){
            imageDataResponse = new ImageDataResponse(null, new Error(1001, Constants.badRequest));
        }
        finally{
            return imageDataResponse;
        }

    }
}
