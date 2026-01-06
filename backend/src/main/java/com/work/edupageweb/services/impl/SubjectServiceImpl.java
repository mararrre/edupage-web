package com.work.edupageweb.services.impl;

import com.work.edupageweb.mappers.SubjectMapper;
import com.work.edupageweb.models.Subject;
import com.work.edupageweb.models.dtos.SubjectDto;
import com.work.edupageweb.repositories.SubjectRepo;
import com.work.edupageweb.services.SubjectService;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepo subjectRepo;
    private final SubjectMapper subjectMapper = SubjectMapper.INSTANCE;

    public SubjectServiceImpl(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    @Override
    public Subject create(SubjectDto subjectDto) {
        Subject subject = subjectMapper.toSubject(subjectDto);

        return subjectRepo.save(subject);
    }
}
