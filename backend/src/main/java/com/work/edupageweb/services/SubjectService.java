package com.work.edupageweb.services;

import com.work.edupageweb.models.Subject;
import com.work.edupageweb.models.dtos.SubjectDto;

public interface SubjectService {

    Subject create(SubjectDto subjectDto);
}
