package com.TheLash.MySpringBootLearning.controller;


import com.TheLash.MySpringBootLearning.entity.JournalEntry;
import com.TheLash.MySpringBootLearning.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

   @Autowired
   private JournalEntryService journalEntryService;

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry newEntry){
        try {
            journalEntryService.saveEntry(newEntry);
            return new ResponseEntity<>(newEntry, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping
    public ResponseEntity<?> getAll(){
        List<JournalEntry> all = journalEntryService.getAll();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<JournalEntry> getById(@PathVariable Long myId){
        Optional<JournalEntry> journalEntry =  journalEntryService.getById(myId);
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<?> delById(@PathVariable Long myId){
        try{
            journalEntryService.deleteById(myId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/id/{myId}")
    public ResponseEntity<?> updateEntriesById(@PathVariable Long myId, @RequestBody JournalEntry updatedEntry){
        JournalEntry entry = journalEntryService.getById(myId).orElse(null);
        if(entry != null){
            entry.setTitle(updatedEntry.getTitle()!=null && !updatedEntry.getTitle().isEmpty() ? updatedEntry.getTitle() : entry.getTitle());
            entry.setContent(updatedEntry.getContent()!=null && !updatedEntry.getContent().isEmpty() ? updatedEntry.getContent(): entry.getContent());
            journalEntryService.saveEntry(entry);
            return new ResponseEntity<>(entry, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
