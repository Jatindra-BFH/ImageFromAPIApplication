package com.jacodplus.ImageApplication.Services;

import com.jacodplus.ImageApplication.Constants;
import com.jacodplus.ImageApplication.Exceptions.ResourceNotFoundException;
import com.jacodplus.ImageApplication.Models.ApiResponse;
import com.jacodplus.ImageApplication.Models.Error;
import com.jacodplus.ImageApplication.Models.ImageRequest;
import com.jacodplus.ImageApplication.Models.ImageResponse;
import com.jacodplus.ImageApplication.Connectors.IRepositories.IAPIConnector;
import com.jacodplus.ImageApplication.Services.IServices.IImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServices implements IImageServices {
    @Autowired
    private IAPIConnector _imageRepository;
    @Override
    public ImageResponse fetchImage(ImageRequest imageRequest) {
        ImageResponse imageResponse = null;
        try {
            var response = _imageRepository.getResource(imageRequest.sourcePath);
            var imageResponseData = response.getData()
                    .getBrandGridByPath()
                    .getItem()
                    .getBrands()
                    .stream()
                    .map(ApiResponse.Brand::getBrandImage)
                    .toList();

            if (!imageResponseData.isEmpty()) {
                imageResponse = new ImageResponse(imageResponseData, null);
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
}
