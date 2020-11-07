package com.hmg.app.flash.service;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmg.app.flash.api.QuestionDto;
import com.hmg.app.flash.model.Deck;
import com.hmg.app.flash.model.Question;
import com.hmg.app.flash.util.QuestionMapper;



public class QuestionService {
    private static final Logger log = LoggerFactory.getLogger(QuestionService.class);

	QuestionMapper questionMapper;
	DeckService deckService;
	
	public QuestionService(QuestionMapper qm) {
		this.questionMapper = qm;
	}
	
	public Question getQuestionById(ObjectContext objContext, String id) {
		
		Question q = ObjectSelect.query(Question.class).where(Question.QUESTION_ID.eq(id)).selectFirst(objContext);
		return (q);
	}

	public QuestionDto addNewQuestion(ObjectContext ctx, QuestionDto questionDto) {
		
		Question question = createQuestion(ctx, questionDto);
		if (questionDto.isTestQuestion()) {
			Deck aDeck = deckService.fetchDeckForId(ctx,questionDto.getTestId());
			aDeck.addToQuestions(question);
		}
		return (questionMapper.questionToDTO(question));
	}

	private Question createQuestion(ObjectContext ctx, QuestionDto questionDto) {
		Question question = ctx.newObject(Question.class);
		if (StringUtils.isEmpty(questionDto.getQuestionId())) {
			questionDto.setQuestionId(RandomStringUtils.randomAlphabetic(8));
		}
		questionMapper.questionDto2Question(question, questionDto);
		ctx.commitChanges();
		return (question);
	}


}
