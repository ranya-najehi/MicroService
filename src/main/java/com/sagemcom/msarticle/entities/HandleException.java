package com.sagemcom.msarticle.entities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandleException {
    @ExceptionHandler(Exception.class)
    public Map<String,String> exceptionHandle(Exception exception){
        Map<String,String> map= new HashMap<>();
        map.put("error", exception.getMessage());
        return map;
    }

   /* @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String,String> IllegalArgumentExceptionHandle(IllegalArgumentException exception){
        Map<String,String> map= new HashMap<>();
        map.put("error", exception.getMessage());
        return map;
    }
*/
}
