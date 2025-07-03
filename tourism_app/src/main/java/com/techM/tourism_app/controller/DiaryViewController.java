package com.techM.tourism_app.controller;

import com.techM.tourism_app.model.DiaryEntry;
import com.techM.tourism_app.model.User;
import com.techM.tourism_app.service.DiaryEntryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class DiaryViewController {

    @Autowired
    private DiaryEntryService diaryEntryService;

    @GetMapping("/diary")
    public String showDiaryForm(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login?error=unauthorized";
        }

        model.addAttribute("entry", new DiaryEntry());
        model.addAttribute("entries", diaryEntryService.getEntriesByUser(user));
        return "my_diary";
    }

    @PostMapping("/diary")
    public String submitDiary(@ModelAttribute DiaryEntry entry, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login?error=unauthorized";
        }

        entry.setUser(user);
        entry.setEntryDate(LocalDate.now());
        diaryEntryService.saveEntry(entry);
        return "redirect:/diary";
    }
}
