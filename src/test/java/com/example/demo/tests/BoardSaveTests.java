package com.example.demo.tests;

import com.example.demo.model.board.BoaedValidationException;
import com.example.demo.model.board.Board;
import com.example.demo.model.board.BoardDao;
import com.example.demo.model.board.BoardSaveService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@Service
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
public class BoardSaveTests {


    @Autowired
    private MockMvc mockMvc;
    private BoardDao dao;


    @Autowired
    private BoardSaveService service;

    private Board board;


    @BeforeEach
    private void init() {
        board = new Board();
        board.setSubject("제목!!");
        board.setContent("내용!!");

    }

    @Test
    @DisplayName("게시글 등록에 성공하면 예외가 발생하지 않음")
    public void saveSuccess() {
        assertDoesNotThrow(() -> {
            service.save(board);
        });
    }

    @Test
    @DisplayName("제목의 null윺효성 검사 미톻ㅇ과 boardVaidationexepotion 발생")
    public void validataionSubjectFied()
    {
        assertThrows(BoaedValidationException.class,()->{
            board.setSubject(null);
            service.save(board);
        });
    }
    @Test
    @DisplayName("제목의 빈값윺효성 검사 미톻ㅇ과 boardVaidationexepotion 발생")
    public void validataionSubjectField() {
        assertThrows(BoaedValidationException.class, () -> {
            board.setSubject("    ");
            service.save(board);
        });
    }

    @Test
    @DisplayName("제목의 nulll유효성 검사 미톻ㅇ과 boardVaidationexepotion 발생")
    public void validataionContentFied()
    {
        assertThrows(BoaedValidationException.class, ()->{
            board.setContent(null);
            service.save(board);
        });
    }
    @Test
    @DisplayName("제목의 빈값 유효성 검사 미톻ㅇ과 boardVaidationexepotion 발생")
    public void validataionContentFied2()
    {
        assertThrows(BoaedValidationException.class,()->{
            board.setContent("    ");
            service.save(board);
        });
    }

    @Test
    @DisplayName("게시글 데이터를 db에반여이시 성공하면 true")
    public void dataInsertTest()
    {

        boolean result = dao.insert(board);
        assertTrue(result);

    }



}
