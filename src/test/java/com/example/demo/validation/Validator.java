package com.example.demo.validation;

import com.example.demo.model.board.Board;

public interface Validator <T>{

    void check(T t);

    default void requiredCheck(String str,RuntimeException e)
    {
        if(str == null||str.isBlank())
        {
            throw e;
        }

    }

    void Check(Board board);
}
