package com.civilink.civilink_contract_manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BidInvitationNotFoundException.class)
    public ResponseEntity<String> handleBidInvitationNotFoundException(BidInvitationNotFoundException ex) {
        // Return a 404 status with a meaningful error message
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
