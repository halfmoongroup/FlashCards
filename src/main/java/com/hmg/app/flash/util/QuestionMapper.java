package com.hmg.app.flash.util;

public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper( Question.class ); 3

    
    QuestionDto mapQuestion(Question aQuestion);
}
