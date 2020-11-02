package com.hmg.app.flash.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.hmg.app.flash.api.request.QuestionDto;
import com.hmg.app.flash.model.Question;

@Mapper
public interface QuestionMapper {
	
    QuestionDto mapQuestion(Question aQuestion);
}
