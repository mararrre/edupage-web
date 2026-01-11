package com.work.edupageweb.controllers;

import com.work.edupageweb.models.Lesson;
import com.work.edupageweb.models.dtos.LessonDto;
import com.work.edupageweb.services.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping("/create/lesson")
    public ResponseEntity<?> createLesson(@RequestBody LessonDto lessonDto) {
        Lesson lesson = lessonService.create(lessonDto);
        return ResponseEntity.ok().body(lesson);
    }

    @GetMapping("/lessons/day")
    public ResponseEntity<?> getLessonDay(@RequestParam Integer day) {
        return null;
    }

    @GetMapping("/lessons/week")
    public ResponseEntity<?> getLessonWeek(@RequestParam Integer week) {
        return null;

    }

    @PutMapping("/lessons/{id}")
    public ResponseEntity<?> updateLesson(@PathVariable Integer id, @RequestBody LessonDto lessonDto) {
        return null;

    }

    @DeleteMapping("/lessons/{id}")
    public ResponseEntity<?> deleteLesson(@PathVariable Integer id) {
        return null;

    }
}
