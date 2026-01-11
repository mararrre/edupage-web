package com.work.edupageweb.services.impl;

import com.work.edupageweb.mappers.LessonMapper;
import com.work.edupageweb.models.Lesson;
import com.work.edupageweb.models.Subject;
import com.work.edupageweb.models.dtos.LessonDto;
import com.work.edupageweb.repositories.LessonRepo;
import com.work.edupageweb.repositories.SubjectRepo;
import com.work.edupageweb.services.LessonService;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {
    private final LessonMapper lessonMapper =LessonMapper.INSTANCE;
    private final LessonRepo lessonRepo;
    private final SubjectRepo subjectRepo;

    public LessonServiceImpl(LessonRepo lessonRepo, SubjectRepo subjectRepo) {
        this.lessonRepo = lessonRepo;
        this.subjectRepo = subjectRepo;
    }

    @Override
    public Lesson create(LessonDto lessonDto) {
        Lesson lesson = lessonMapper.toLesson(lessonDto);
        Subject subject = subjectRepo.findById(lessonDto.subject()).orElseThrow();
        lesson.setSubject(subject);
        return lessonRepo.save(lesson);
    }


}
