package com.arshiya.MyMoviePlan.exception;

public class MovieShowNotFoundException extends RuntimeException {
    public MovieShowNotFoundException(String message) {
        super(message);
    }
}
