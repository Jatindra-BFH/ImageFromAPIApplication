package com.jacodplus.ImageApplication.Connectors.IRepositories;

import com.jacodplus.ImageApplication.Models.ApiResponse;

public interface IAPIConnector {
    public ApiResponse getResource(String basePath) throws Exception;
}
