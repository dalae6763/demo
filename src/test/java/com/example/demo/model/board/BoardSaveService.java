package com.example.demo.model.board;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.Errors;

import javax.security.auth.Subject;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@Service
@RequiredArgsConstructor
public class BoardSaveService {

    private final BoardSaveValidator validator;
    public void save(Board board){
        validator.Check(board);

    }



}
