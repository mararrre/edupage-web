package com.work.edupageweb.controllers;

import com.work.edupageweb.models.Lesson;
import com.work.edupageweb.models.dtos.LessonDto;
import com.work.edupageweb.services.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

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
    public ResponseEntity<List<Lesson>> getLessonDay(@RequestParam DayOfWeek dayOfWeek) {
        return ResponseEntity.ok(lessonService.getLessonsForDay(dayOfWeek));
    }

    @GetMapping("/lessons/week")
    public ResponseEntity<List<Lesson>> getLessonWeek() {
        return ResponseEntity.ok(lessonService.getLessonsForWeek());
    }

    @PutMapping("/lessons/{id}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable Long id, @RequestBody Lesson lessonDto) {
        return ResponseEntity.ok(lessonService.update(id, lessonDto));

    }

    @DeleteMapping("/lessons/{id}")
    public String deleteLesson(@PathVariable Long id) {
        return lessonService.delete(id);

    }
}
