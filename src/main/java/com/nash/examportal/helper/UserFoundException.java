package com.nash.examportal.helper;

public class UserFoundException extends Exception {
    public UserFoundException() {
        super("User with username already exists, try other username");
    }

    public UserFoundException(String msg) {
        super(msg);
    }
}
