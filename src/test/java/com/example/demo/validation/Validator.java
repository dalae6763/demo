package com.example.demo.validation;

public interface Validator <T>{

    void check(T t);

    default void requiredCheck(String str,RuntimeException e)
    {
        if(str == null||str.isBlank())
        {
            throw e;
        }

    }

}
