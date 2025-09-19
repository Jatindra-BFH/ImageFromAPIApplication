package com.jacodplus.ImageApplication.Models;

import org.springframework.core.io.Resource;

public class ImageDataResponse {
    public Resource image;
    public Error error;
    public ImageDataResponse(Resource image, Error error){
        this.image = image;
        this.error = error;
    }
}
