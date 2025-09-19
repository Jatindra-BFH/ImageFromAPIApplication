package com.jacodplus.ImageApplication.Exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String message){
        super(message);
    }
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}
