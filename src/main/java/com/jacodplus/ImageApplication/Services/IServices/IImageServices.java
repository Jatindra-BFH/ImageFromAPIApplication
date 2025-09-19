package com.jacodplus.ImageApplication.Services.IServices;

import com.jacodplus.ImageApplication.Models.ImageDataRequest;
import com.jacodplus.ImageApplication.Models.ImageDataResponse;
import com.jacodplus.ImageApplication.Models.ImageRequest;
import com.jacodplus.ImageApplication.Models.ImageResponse;

public interface IImageServices {
    public ImageResponse fetchImages(ImageRequest imageRequest);
    public ImageDataResponse fetchImage(ImageDataRequest imageDataRequest);
}
