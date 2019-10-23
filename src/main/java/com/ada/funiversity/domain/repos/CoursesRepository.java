package com.ada.funiversity.domain.repos;

import com.ada.funiversity.domain.Course;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class CoursesRepository {

    private final ConcurrentHashMap<String, Course> coursesById;

    public CoursesRepository() {
        coursesById = new ConcurrentHashMap<>();
    }

    Course save(Course courseToSave) {
        coursesById.put(courseToSave.getId(), courseToSave);
        return courseToSave;
    }

    Course getCourseById(String id) {
        if(!isCourseIdInRepository(id)) {
            throw new IllegalArgumentException("No course found for id: " + id);
        }
        return coursesById.get(id);
    }

    private boolean isCourseIdInRepository(String id) {
        return coursesById.containsKey(id);
    }

    Collection<Course> getCourses(int studyPointsFilter) {
        if(studyPointsFilter < Course.getMinStudyPoints() || studyPointsFilter > Course.getMaxStudyPoints()) {
            return coursesById.values();
        }
        return coursesById
                .values()
                .stream()
                .filter(course -> course.getStudyPoints() == studyPointsFilter)
                .collect(Collectors.toList());
    }
}
