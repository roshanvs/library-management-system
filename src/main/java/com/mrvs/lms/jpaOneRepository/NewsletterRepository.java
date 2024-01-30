package com.mrvs.lms.jpaOneRepository;

import com.mrvs.lms.NewsletterConfig;
import com.mrvs.lms.jpaOneModel.NewsLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsletterRepository extends JpaRepository<NewsLetter,Long> {
}
