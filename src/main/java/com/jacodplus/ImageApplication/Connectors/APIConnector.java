package com.jacodplus.ImageApplication.Connectors;

import com.jacodplus.ImageApplication.Constants;
import com.jacodplus.ImageApplication.Exceptions.ResourceNotFoundException;
import com.jacodplus.ImageApplication.Models.ApiResponse;
import com.jacodplus.ImageApplication.Connectors.IRepositories.IAPIConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class APIConnector implements IAPIConnector {
    @Autowired
    private WebClient webClient;
    @Override
    public ApiResponse getResource(String sourcePath) throws Exception{
        try {
            return webClient.get()
                    .uri(sourcePath)
                    .retrieve()
                    .bodyToMono(ApiResponse.class).block();
        }catch (Exception ex){
            throw new ResourceNotFoundException(Constants.resourceNotFound);
        }
    }
    @Override
    public Resource getResourceData(String source) throws Exception{
        try {
            return webClient.get()
                    .uri(source)
                    .retrieve()
                    .bodyToMono(Resource.class).block();
        }catch (Exception ex){
            throw new ResourceNotFoundException(Constants.resourceNotFound);
        }
    }
}
