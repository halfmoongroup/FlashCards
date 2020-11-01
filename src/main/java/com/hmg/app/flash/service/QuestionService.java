package com.hmg.app.flash.service;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;

import com.hmg.app.flash.model.Question;

public class QuestionService {
	
	public Question getQuestionById(ObjectContext objContext, String id) {
		Question q = ObjectSelect.query(Question.class).where(Question.QUESTION_ID.eq(id)).selectFirst(objContext);
		return (null);
	}

}
