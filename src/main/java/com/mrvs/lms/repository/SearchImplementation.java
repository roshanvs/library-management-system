package com.mrvs.lms.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mrvs.lms.model.Journal;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class SearchImplementation implements SearchRepository {
    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Journal> findByText(String text) {

        final List<Journal> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("l-m-s");
        MongoCollection<Document> collection = database.getCollection("Journals");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("techs", "desc", "author")))),
                new Document("$sort",
                        new Document("volumes", 1L)),
                new Document("$limit", 5L)));
        boolean hasDocument =result.iterator().hasNext();

        result.forEach(doc -> posts.add(converter.read(Journal.class,doc)));

        return posts;
    }
}
