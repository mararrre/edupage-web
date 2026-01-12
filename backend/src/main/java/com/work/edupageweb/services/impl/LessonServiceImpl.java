package com.work.edupageweb.services.impl;

import com.work.edupageweb.mappers.LessonMapper;
import com.work.edupageweb.models.Lesson;
import com.work.edupageweb.models.Subject;
import com.work.edupageweb.models.dtos.LessonDto;
import com.work.edupageweb.repositories.LessonRepo;
import com.work.edupageweb.repositories.SubjectRepo;
import com.work.edupageweb.services.LessonService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

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

    @Override
    public List<Lesson> getLessonsForDay(DayOfWeek dayOfWeek) {
        return lessonRepo.findAllByDayOfWeek(dayOfWeek);
    }

    @Override
    public List<Lesson> getLessonsForWeek() {
        return lessonRepo.findAll();
    }

    @Override
    public Lesson update(Long id, Lesson lessonDto) {
        Lesson lesson = lessonRepo.findById(id).orElseThrow();
        lesson.setSubject(lessonDto.getSubject());
        lesson.setDayOfWeek(lessonDto.getDayOfWeek());
        lesson.setTime(lessonDto.getTime());
        return lessonRepo.save(lesson);
    }

    @Override
    public String delete(Long id) {
        lessonRepo.deleteById(id);
        return "Lesson has been deleted";
    }



}
