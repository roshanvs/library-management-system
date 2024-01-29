package com.mrvs.lms.controller;

import com.mrvs.lms.model.Journal;
import com.mrvs.lms.service.JournalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journals")
@CrossOrigin(origins="*")
public class JournalController {
private JournalService journalService;
JournalController(JournalService journalService){
    this.journalService =journalService;
}
   @GetMapping("/allJournals")
    public List<Journal> getAllJournals(){
        return journalService.getAllJournals();
    }
    @PostMapping("/newJournal")
    public Journal newJournal(@RequestBody Journal journal){
    return journalService.newJournal(journal);

    }
    @GetMapping("/find/{text}")
    public List<Journal> findByAuthor(@PathVariable String text){
    return journalService.findByAuthor(text);
    }

    @GetMapping("/search/{text}")
    public List<Journal> findByText(@PathVariable String text){
        return journalService.findByText(text);
    }




}
