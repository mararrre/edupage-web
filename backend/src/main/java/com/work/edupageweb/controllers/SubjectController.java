package com.work.edupageweb.controllers;

import com.work.edupageweb.models.Subject;
import com.work.edupageweb.models.dtos.SubjectDto;
import com.work.edupageweb.services.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/create/subject")
    public ResponseEntity<?> createSubject(@RequestBody SubjectDto subjectDto) {
        Subject subject = subjectService.create(subjectDto);
        return ResponseEntity.ok(subject);
    }
}
