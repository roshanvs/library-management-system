package com.mrvs.lms;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = {"com.mrvs.lms.mongoModel","com.mrvs.lms.mongoRepository"}, mongoTemplateRef = "mongoTemplate")
@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
    @Value("${mongodb.uri}")
    private String uri;

    @Value("${mongodb.database}")
    private String database;
    @Override
    protected String getDatabaseName() {
        return database; // Replace with your database name
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(uri+"/"+database); // Replace with your MongoDB host and port
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }
}
