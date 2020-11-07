package com.hmg.app.flash.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.hmg.app.flash.api.QuestionDto;
import com.hmg.app.flash.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestionMapper {
	  final static Logger logger = LoggerFactory.getLogger(QuestionMapper.class);


   public  QuestionDto questionToDTO(Question aQuestion) {
    	QuestionDto newBean = new QuestionDto();
    	try {
			BeanUtils.copyProperties(newBean, aQuestion);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.warn("error mapping question bean");
			e.printStackTrace();
		}
    	return newBean;
    }
	

	public Question questionDto2Question(Question dest, QuestionDto src ) {
    	try {
			BeanUtils.copyProperties(dest,src);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.warn("error mapping question bean");
			e.printStackTrace();
		}
    	return dest;
	}
}
