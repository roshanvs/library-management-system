package com.mrvs.lms.mongoRepository;

import com.mrvs.lms.mongoModel.Journal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository {
List<Journal> findByText(String Text);
}
