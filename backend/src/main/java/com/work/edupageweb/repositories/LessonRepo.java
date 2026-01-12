package com.work.edupageweb.repositories;

import com.work.edupageweb.models.Lesson;
import com.work.edupageweb.models.dtos.LessonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface LessonRepo extends JpaRepository<Lesson, Long> {

    List<Lesson> findAllByDayOfWeek(DayOfWeek dayOfWeek);
}
