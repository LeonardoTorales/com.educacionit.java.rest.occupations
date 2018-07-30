

package com.educacionit.java.rest.occupations.test;


import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;


@Configuration
@EnableMongoRepositories (basePackages = {"com.educacionit.java.rest.occupations.repository"})
public class MongodbConfiguration extends AbstractMongoConfiguration {


    @Autowired
    private Environment env;


	public MongodbConfiguration () {

		super ();
	}
	

    @Override
    public String getDatabaseName () {

        return env.getRequiredProperty ("spring.data.mongodb.database");
    }


    @Override
    @Bean
    public Mongo mongo () {

        ServerAddress serverAddress = new ServerAddress (env.getRequiredProperty ("spring.data.mongodb.host"));
        List<MongoCredential> credentials = new ArrayList<> ();
        MongoClientOptions     options = new MongoClientOptions.Builder ().build ();
        return new MongoClient (serverAddress, credentials, options);
    }
}