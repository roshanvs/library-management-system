package com.mrvs.lms.mongoRepository;

import com.mrvs.lms.mongoModel.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends MongoRepository<Journal,String> {
    List<Journal> findByAuthor(String text);
}
