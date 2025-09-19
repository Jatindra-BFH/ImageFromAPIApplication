package com.jacodplus.ImageApplication.Repositories.IRepositories;

import com.jacodplus.ImageApplication.Models.ApiResponse;

public interface IImageRepository {
    public ApiResponse getResource(String basePath) throws Exception;
}
