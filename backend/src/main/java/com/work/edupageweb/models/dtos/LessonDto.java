package com.work.edupageweb.models.dtos;

import com.work.edupageweb.enums.DayOfWeek;

import java.time.LocalTime;

public record LessonDto (
    Long subject,
    DayOfWeek dayOfWeek,
    LocalTime time

){
}
