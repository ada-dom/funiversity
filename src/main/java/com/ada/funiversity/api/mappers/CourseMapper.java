package com.ada.funiversity.api.mappers;

import com.ada.funiversity.api.dtos.CourseDto;
import com.ada.funiversity.domain.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDto mapToDto(Course course) {
        return new CourseDto()
                .setId(course.getId())
                .setName(course.getName())
                .setProfessorId(course.getProfessorId())
                .setStudyPoints(course.getStudyPoints());
    }
}
