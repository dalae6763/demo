package com.example.demo.model.board;

import com.example.demo.validation.Validator;
import org.springframework.stereotype.Component;

@Component
public class BoardSaveValidator implements Validator<Board> {

    @Override
    public void Check(Board board)
    {

        String subject = board.getSubject();
        String content = board.getContent();
//        제목체ㅓ크
        if(subject == null||subject.isBlank())
        {
            throw new BoaedValidationException(" 내용을 입력 ");
        }
        //        내용체크
        if(content == null||content.isBlank())
        {
            throw new BoaedValidationException(" 제목을 입력 ");
        }
    }

}
