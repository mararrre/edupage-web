package com.work.edupageweb.controllers;

import com.work.edupageweb.models.dtos.LessonDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lessons") // Проверь, чтобы было так, как в ТЗ
@Tag(name = "Расписание", description = "Управление занятиями")
public class LessonController {

    // Оставляем метод коллег, просто добавляем описание для Swagger
    @PostMapping("/create/lesson")
    @Operation(summary = "Добавить новое занятие")
    public ResponseEntity<?> createLesson(@RequestBody LessonDto lessonDto) {
        return ResponseEntity.ok("Занятие принято в обработку");
    }

    // Твой новый эндпоинт из Шага 2
    @GetMapping("/week")
    @Operation(summary = "Получить расписание на неделю")
    public ResponseEntity<String> getWeeklySchedule() {
        return ResponseEntity.ok("Список занятий на неделю (интеграция завершена)");
    }
}