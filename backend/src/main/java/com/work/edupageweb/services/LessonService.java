package com.work.edupageweb.services;

import com.work.edupageweb.models.Lesson;
import com.work.edupageweb.models.dtos.LessonDto;

import java.time.DayOfWeek;
import java.util.List;

public interface LessonService {
    Lesson create(LessonDto lessonDto);

    List<Lesson> getLessonsForDay(DayOfWeek dayOfWeek);

    List<Lesson> getLessonsForWeek();

    Lesson update(Long id, Lesson lessonDto);
    String delete(Long id);
}
