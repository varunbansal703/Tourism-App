package com.techM.tourism_app.repository;

import com.techM.tourism_app.model.DiaryEntry;
import com.techM.tourism_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, Long> {
    List<DiaryEntry> findByUser(User user);
}
