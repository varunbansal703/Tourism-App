package com.techM.tourism_app.service;

import com.techM.tourism_app.model.DiaryEntry;
import com.techM.tourism_app.model.User;

import java.util.List;

public interface DiaryEntryService {
    DiaryEntry saveEntry(DiaryEntry entry);              // used in DiaryViewController
    DiaryEntry createEntry(DiaryEntry entry);            // needed for DiaryEntryController
    List<DiaryEntry> getEntriesByUserId(Long userId);
    List<DiaryEntry> getEntriesByUser(User user);
}
