package com.hmg.app.flash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmg.app.flash.resource.QuestionResource;

import io.bootique.BQCoreModule;
import io.bootique.Bootique;
import io.bootique.di.BQModule;
import io.bootique.di.Binder;
import io.bootique.jersey.JerseyModule;

public class FlashCards {
    private static final Logger log = LoggerFactory.getLogger(FlashCards.class);

	public static void main(String[] args) {
		log.debug("Starting flashcard application");
		BQModule module = binder -> 
			JerseyModule.extend(binder)
				.addResource(QuestionResource.class)
				;

		Bootique
			.app(args)
			.module(module)
			.autoLoadModules()
			.exec()
			.exit();
	}
    public void configure(Binder binder) {

    BQCoreModule.extend(binder)
    	.declareVar("jdbc.db1.username", "CM_JDBC_USERNAME")
    	.declareVar("jdbc.db1.password", "CM_JDBC_PASSWORD")
    	.declareVar("jdbc.db1.jdbcUrl", "CM_JDBC_URL")
    	.declareVar("cohortManager.bucketName","CM_BUCKET_NAME")
    	.declareVar("cohortManager.digitalBucketName", "CM_DIGITAL_BUCKET");
    }
}
