package com.sharethis.bootstrap.mongo;

import com.sharethis.bootstrap.Backend;
import com.sharethis.bootstrap.model.ModelObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component("mongo")
public class MongoBackend implements Backend {

	@Autowired
	MongoTemplate mongoTemplate;

    @Override
    public ModelObject addSugar(String string) {
        return null;
    }
}
