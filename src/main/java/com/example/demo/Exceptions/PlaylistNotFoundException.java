package com.example.demo.Exceptions;

public class PlaylistNotFoundException extends RuntimeException {

    public PlaylistNotFoundException() {
        super();   
    }

    public PlaylistNotFoundException(String message) {
        super(message);
    } 
}