package com.example.demo.model.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BoardDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insert(Board board)
    {
        String sql="Insert INTO board(subject,content) VALUSE(?,?)";
        int cnt = jdbcTemplate.update(sql,board.getSubject(),board.geContent());
        return cnt>0;
    }

}
