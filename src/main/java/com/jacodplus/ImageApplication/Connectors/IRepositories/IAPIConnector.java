package com.jacodplus.ImageApplication.Connectors.IRepositories;

import com.jacodplus.ImageApplication.Models.ApiResponse;
import org.springframework.core.io.Resource;

import java.util.List;

public interface IAPIConnector {
    public ApiResponse getResource(String basePath) throws Exception;
    public Resource getResourceData(String source) throws Exception;
}
