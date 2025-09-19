package com.jacodplus.ImageApplication.Models;

public class Error {
    public int errorCode;
    public String errorMessage;
    public Error(int code, String message){
        this.errorCode = code;
        this.errorMessage = message;
    }
}
