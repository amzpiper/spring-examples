package com.guoyuhang.controller;

public class SpitterNotFoundException extends RuntimeException {

    private long spitterId;

    public SpitterNotFoundException(long spitterId) {
        this.spitterId = spitterId;
    }

    public long getSpitterId() {
        return spitterId;
    }
}
