package com.mrvs.lms.repository;

import com.mrvs.lms.model.Journal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository {
List<Journal> findByText(String Text);
}
