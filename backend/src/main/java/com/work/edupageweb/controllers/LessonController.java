package com.work.edupageweb.controllers;

import com.work.edupageweb.models.Lesson;
import com.work.edupageweb.models.dtos.LessonDto;
import com.work.edupageweb.services.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
