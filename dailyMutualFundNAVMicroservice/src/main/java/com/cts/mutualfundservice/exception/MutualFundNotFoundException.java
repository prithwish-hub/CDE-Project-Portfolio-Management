package com.cts.mutualfundservice.exception;

public class MutualFundNotFoundException extends RuntimeException {
    public MutualFundNotFoundException(String message) {
        super(message);
    }
}
