package com.techM.tourism_app.controller;

import com.techM.tourism_app.model.DiaryEntry;
import com.techM.tourism_app.service.DiaryEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diary")
@CrossOrigin(origins = "*")
public class DiaryEntryController {

    @Autowired
    private DiaryEntryService diaryEntryService;

    // ✅ Add a new diary entry
    @PostMapping
    public DiaryEntry createEntry(@RequestBody DiaryEntry entry) {
        return diaryEntryService.createEntry(entry);
    }

    // ✅ Get all entries by user ID
    @GetMapping("/user/{userId}")
    public List<DiaryEntry> getEntriesByUserId(@PathVariable Long userId) {
        return diaryEntryService.getEntriesByUserId(userId);
    }
}
