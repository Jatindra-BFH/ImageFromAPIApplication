package com.jacodplus.ImageApplication.Models;

import org.springframework.core.io.Resource;

import java.util.List;

public class ImageResponse {
    public List<String> data = null;
    public Error error = null;
    public ImageResponse(List<String> data, Error error){
        this.data = data;
        this.error = error;
    }
}
