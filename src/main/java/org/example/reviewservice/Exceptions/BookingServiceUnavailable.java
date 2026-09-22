package org.example.reviewservice.Exceptions;

public class BookingServiceUnavailable extends RuntimeException {
    public BookingServiceUnavailable(String message) {
        super(message);
    }
}
