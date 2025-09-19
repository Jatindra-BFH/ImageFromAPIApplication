package com.jacodplus.ImageApplication.Controllers;

import com.jacodplus.ImageApplication.Models.ImageRequest;
import com.jacodplus.ImageApplication.Models.ImageResponse;
import com.jacodplus.ImageApplication.Services.IServices.IImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    private IImageServices _imageService;

    @Value("${source.path}")
    private String sourcePath;

    @GetMapping("/images")
    public ResponseEntity<ImageResponse> getImage() throws Exception {
        try {
            var request = new ImageRequest(sourcePath);
            var response = _imageService.fetchImage(request);

            if (response.data != null) {
                return ResponseEntity.ok()
                        .body(response);
            }
            else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

        } catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
