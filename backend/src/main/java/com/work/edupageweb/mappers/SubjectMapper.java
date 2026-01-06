package com.work.edupageweb.mappers;

import com.work.edupageweb.models.Subject;
import com.work.edupageweb.models.dtos.SubjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectMapper {
    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);
    Subject toSubject(SubjectDto subjectDto);
}
