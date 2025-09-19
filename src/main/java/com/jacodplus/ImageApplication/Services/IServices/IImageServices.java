package com.jacodplus.ImageApplication.Services.IServices;

import com.jacodplus.ImageApplication.Models.ImageRequest;
import com.jacodplus.ImageApplication.Models.ImageResponse;

public interface IImageServices {
    public ImageResponse fetchImage(ImageRequest imageRequest);
}
