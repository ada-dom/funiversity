package com.ada.funiversity.domain.repos;

import com.ada.funiversity.domain.Course;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class CoursesRepository {

    private final ConcurrentHashMap<String, Course> coursesById;

    public CoursesRepository() {
        coursesById = new ConcurrentHashMap<>();
    }

    public Course save(Course courseToSave) {
        coursesById.put(courseToSave.getId(), courseToSave);
        return courseToSave;
    }

    public Course getCourseById(String id) {
        if(!isCourseIdInRepository(id)) {
            throw new IllegalArgumentException("No course found for id: " + id);
        }
        return coursesById.get(id);
    }

    private boolean isCourseIdInRepository(String id) {
        return coursesById.containsKey(id);
    }
}
