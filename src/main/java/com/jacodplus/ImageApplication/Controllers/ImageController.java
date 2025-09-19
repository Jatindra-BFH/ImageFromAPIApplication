package com.jacodplus.ImageApplication.Controllers;

import com.jacodplus.ImageApplication.Models.ImageDataRequest;
import com.jacodplus.ImageApplication.Models.ImageRequest;
import com.jacodplus.ImageApplication.Models.ImageResponse;
import com.jacodplus.ImageApplication.Services.IServices.IImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    private IImageServices _imageService;
    @Value("${base.path}")
    private String basePath;
    @Value("${source.path}")
    private String sourcePath;

    @GetMapping("/images")
    public ResponseEntity<ImageResponse> getImages() throws Exception {
        try {
            var request = new ImageRequest(basePath, sourcePath);
            var response = _imageService.fetchImages(request);

            if (response.data != null) {

                // Return the resources as the response
                return ResponseEntity.ok().body(response);
            }
            else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

        } catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/image")
    public ResponseEntity<Resource> getImage(@RequestParam String path) throws Exception {
        try {
            var request = new ImageDataRequest(basePath + path);
            var response = _imageService.fetchImage(request);

            if (response.image != null) {
                return ResponseEntity.ok().body(response.image);
            }
            else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

        } catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
