package com.TheLash.journalApp.controller;

import com.TheLash.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @PostMapping()
    public boolean createEntity(@RequestBody JournalEntry newEntity){
        journalEntries.put(newEntity.getId(), newEntity);
        return true;
    }

    @GetMapping()
    public List<JournalEntry> getAllEntry(){
        return new ArrayList<>(journalEntries.values());
    }

    @PutMapping("/id/{userId}")
    public JournalEntry updateById(@PathVariable Long userId, @RequestBody JournalEntry updatedEntry){
        return journalEntries.put(userId, updatedEntry);
    }

    @GetMapping("/id/{userId}")
    public JournalEntry getEntryById(@PathVariable Long userId){
        return journalEntries.get(userId);
    }


    @DeleteMapping("/id/{userId}")
    public JournalEntry deleteEntryById(@PathVariable Long userId){
        JournalEntry deletedEntry = journalEntries.get(userId);
        journalEntries.remove(userId);
        return deletedEntry;
    }
}
