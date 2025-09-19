package com.jacodplus.ImageApplication.Models;

import java.nio.file.Path;

public class ImageRequest {
    public String basePath;
    public String sourcePath;
    public ImageRequest(String basePath,String sourcePath){
        this.basePath = basePath;
        this.sourcePath = sourcePath;
    }
}
