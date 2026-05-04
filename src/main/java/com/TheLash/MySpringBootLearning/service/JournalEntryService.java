package com.TheLash.MySpringBootLearning.service;

import com.TheLash.MySpringBootLearning.entity.JournalEntry;
import com.TheLash.MySpringBootLearning.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }


    public List<JournalEntry>  getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getById(Long id){
        return journalEntryRepository.findById(id);
    }

    public void deleteById(Long myid){
        journalEntryRepository.deleteById(myid);
    }
    
}


// controller ---> service ---> repository