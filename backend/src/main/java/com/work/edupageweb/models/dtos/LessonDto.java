package com.work.edupageweb.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Объект для передачи данных занятия (DTO)")
public class LessonDto {
    @Schema(example = "1", description = "ID предмета")
    private Long subjectId;

    @Schema(example = "MONDAY", description = "День недели")
    private String dayOfWeek;

    @Schema(example = "09:00", description = "Время начала занятия")
    private String time;
}