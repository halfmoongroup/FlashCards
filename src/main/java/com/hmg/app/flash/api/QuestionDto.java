package com.hmg.app.flash.api;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import lombok.Data;

@Data
public class QuestionDto {
    private static final Logger log = LoggerFactory.getLogger(QuestionDto.class);

	private String question;
	private String answer;
	private String questionImageUrl;
	private String answerImageUrl;
	private String questionId;
	private String deckId;
	private String testId;
	
	public boolean isTestQuestion() {
		log.debug("is question in deck: "+deckId );
		return StringUtils.isNotEmpty(deckId);
	}

}
