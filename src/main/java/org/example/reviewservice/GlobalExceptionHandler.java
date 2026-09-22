package org.example.reviewservice;

import org.example.reviewservice.Exceptions.BookingServiceUnavailable;
import org.example.reviewservice.Exceptions.CustomerServiceUnavailableException;
import org.example.reviewservice.Exceptions.InvalidReviewDataException;
import org.example.reviewservice.Exceptions.ReviewNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> handleReviewNotFound(ReviewNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleCustomerServiceUnavailable(CustomerServiceUnavailableException exception) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleInvalidReviewData(InvalidReviewDataException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleBookingServiceUnavailable(BookingServiceUnavailable exception) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(exception.getMessage());
    }
}
