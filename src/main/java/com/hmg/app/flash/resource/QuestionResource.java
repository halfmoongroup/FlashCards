package com.hmg.app.flash.resource;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmg.app.flash.api.QuestionDto;
import com.hmg.app.flash.service.QuestionService;

@Path("/question")
public class QuestionResource {
    private static final Logger log = LoggerFactory.getLogger(QuestionResource.class);

	private ServerRuntime serverRuntime;
	private QuestionService questionService;
	
	@PUT
	public Response addQuestion(QuestionDto questionDto) {
		log.debug("addQuestion: "+questionDto.getQuestion());
		Response resp = null;
		ObjectContext ctx = serverRuntime.newContext();
		QuestionDto response = questionService.addNewQuestion(ctx,questionDto);
		if (response != null) {
			resp = Response.status(Response.Status.OK).entity(response).build(); 
		} else {
			resp = Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		return Response.status(Response.Status.OK).entity(response).build(); 
	}

}
