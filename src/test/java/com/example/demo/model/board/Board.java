package com.example.demo.model.board;

import lombok.Data;

@Data
public class Board {
    private long id;//게시글번호
    private String subject;//제목
    private String content;//내용
}
