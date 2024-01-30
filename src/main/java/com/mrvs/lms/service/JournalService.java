package com.mrvs.lms.service;

import com.mrvs.lms.mongoModel.Journal;
import com.mrvs.lms.mongoRepository.JournalRepository;
import com.mrvs.lms.mongoRepository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {
    private JournalRepository journalRepository;
    private SearchRepository searchRepository;

    JournalService(JournalRepository journalRepository, SearchRepository searchRepository){
        this.journalRepository=journalRepository;
        this.searchRepository = searchRepository;
    }

    public List<Journal> getAllJournals() {
      return   journalRepository.findAll();
    }
    public List<Journal> findByAuthor(String text){
        return journalRepository.findByAuthor(text);
    }

    public Journal newJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    public List<Journal> findByText(String text) {
        return searchRepository.findByText(text);
    }
}
