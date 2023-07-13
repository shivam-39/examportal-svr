package com.nash.examportal.helper;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User with username do not exists, try other username");
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
