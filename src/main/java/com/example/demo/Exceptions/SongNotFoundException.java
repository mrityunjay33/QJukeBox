package com.example.demo.Exceptions;

public class SongNotFoundException extends RuntimeException{
    public SongNotFoundException(){
        super();
    }

    public SongNotFoundException(String message){
        super(message);
    }
}
