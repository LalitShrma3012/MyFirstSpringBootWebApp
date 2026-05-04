package com.TheLash.MySpringBootLearning.controller;


import com.TheLash.MySpringBootLearning.entity.JournalEntry;
import com.TheLash.MySpringBootLearning.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

   @Autowired
   private JournalEntryService journalEntryService;

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry newEntry){
        journalEntryService.saveEntry(newEntry);
        return true;
    }
    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getById(@PathVariable Long myId){
        return journalEntryService.getById(myId).orElse(null);
    }

    @DeleteMapping("/id/{myId}")
    public boolean delById(@PathVariable Long myId){
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("/id/{myId}")
    public boolean updateEntriesById(@PathVariable Long myId, @RequestBody JournalEntry updatedEntry){
        JournalEntry entry = journalEntryService.getById(myId).orElse(null);
        if(entry != null){
            entry.setTitle(updatedEntry.getTitle()!=null && !updatedEntry.getTitle().isEmpty() ? updatedEntry.getTitle() : entry.getTitle());
            entry.setContent(updatedEntry.getContent()!=null && !updatedEntry.getContent().isEmpty() ? updatedEntry.getContent(): entry.getContent());
        }
        journalEntryService.saveEntry(entry);
        return true;
    }
}
