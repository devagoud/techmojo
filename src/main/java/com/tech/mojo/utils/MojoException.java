package com.tech.mojo.utils;

import lombok.Getter;

@Getter
public class MojoException extends RuntimeException {
    public String message;

    public MojoException(String message){
        this.message=message;
    }

}
