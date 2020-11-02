package com.hmg.app.flash.resource;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;

import com.hmg.app.flash.api.request.QuestionDto;
import com.hmg.app.flash.model.Question;
import com.hmg.app.flash.service.QuestionService;

@Path("/question")
public class QuestionResource {
	
	private ServerRuntime serverRuntime;
	private QuestionService questionService;
	
	@PUT
	public void addQuestion(QuestionDto question) {
		ObjectContext oc = serverRuntime.newContext();
		
		Question q = ObjectSelect.query(Question.class).selectFirst(oc);
		
	}

}
