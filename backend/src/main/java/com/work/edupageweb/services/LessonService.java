package com.work.edupageweb.services;

import com.work.edupageweb.models.Lesson;
import com.work.edupageweb.models.dtos.LessonDto;

public interface LessonService {
    Lesson create(LessonDto lessonDto);
}
