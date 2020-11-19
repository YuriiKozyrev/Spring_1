package com.geekbrains.spring.mvc.exceptions;

public class GoodsNotFoundException extends RuntimeException{
    public GoodsNotFoundException(String message) {
        super(message);
    }
}
