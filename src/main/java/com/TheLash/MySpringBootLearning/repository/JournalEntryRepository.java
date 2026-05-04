package com.TheLash.MySpringBootLearning.repository;


import com.TheLash.MySpringBootLearning.entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {

}
