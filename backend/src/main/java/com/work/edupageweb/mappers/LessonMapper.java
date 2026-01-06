package com.work.edupageweb.mappers;

import com.work.edupageweb.models.Lesson;
import com.work.edupageweb.models.dtos.LessonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LessonMapper {
    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);
    @Mapping(target = "subject.id", source = "subject")
    Lesson toLesson(LessonDto lessonDto);
}
