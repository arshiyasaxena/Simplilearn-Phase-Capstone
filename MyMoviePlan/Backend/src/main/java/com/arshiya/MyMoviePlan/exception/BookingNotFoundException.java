package com.arshiya.MyMoviePlan.exception;

public class BookingNotFoundException extends RuntimeException{

    public BookingNotFoundException(String message) {
        super(message);
    }
}
