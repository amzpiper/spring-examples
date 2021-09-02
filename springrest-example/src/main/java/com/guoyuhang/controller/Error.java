package com.guoyuhang.controller;

public class Error {
    private int id;
    private String message;

    public Error(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
