package com.techM.tourism_app.service.impl;

import com.techM.tourism_app.model.DiaryEntry;
import com.techM.tourism_app.model.User;
import com.techM.tourism_app.repository.DiaryEntryRepository;
import com.techM.tourism_app.repository.UserRepository;
import com.techM.tourism_app.service.DiaryEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryEntryServiceImpl implements DiaryEntryService {

    @Autowired
    private DiaryEntryRepository diaryEntryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public DiaryEntry saveEntry(DiaryEntry entry) {
        return diaryEntryRepository.save(entry);
    }

    @Override
    public DiaryEntry createEntry(DiaryEntry entry) {
        return diaryEntryRepository.save(entry);
    }

    @Override
    public List<DiaryEntry> getEntriesByUser(User user) {
        return diaryEntryRepository.findByUser(user);
    }

    @Override
    public List<DiaryEntry> getEntriesByUserId(Long userId) {
        return userRepository.findById(userId)
                .map(diaryEntryRepository::findByUser)
                .orElse(List.of());
    }
}
