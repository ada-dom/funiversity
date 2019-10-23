package com.ada.funiversity.api;

import com.ada.funiversity.api.dtos.CourseDto;
import com.ada.funiversity.api.dtos.CreateCourseDto;
import com.ada.funiversity.api.mappers.CourseMapper;
import com.ada.funiversity.domain.Course;
import com.ada.funiversity.domain.repos.FuniversityRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path= "/courses")
@ComponentScan("com.ada.fununiversity")
public class CoursesController {

    public static final String APPLICATION_JSON = "application/json";
    private FuniversityRepositoryService funiversityRepositoryService;
    private CourseMapper courseMapper;

    @Autowired
    public CoursesController(FuniversityRepositoryService funiversityRepositoryService, CourseMapper courseMapper) {
        this.funiversityRepositoryService = funiversityRepositoryService;
        this.courseMapper = courseMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto createCourse(CreateCourseDto createCourseDto) {
        return courseMapper.mapToDto(
                new Course(
                        createCourseDto.getName(),
                        createCourseDto.getStudyPoints(),
                        createCourseDto.getProfessorId()));
    }

    @GetMapping(produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDto> getCourses(@RequestParam(defaultValue = "0") int studyPointsFilter) {
        return funiversityRepositoryService
                .getCourses(studyPointsFilter)
                .stream()
                .map(course -> this.courseMapper.mapToDto(course))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    public CourseDto getCourse(@PathVariable("id") String id) {
        return courseMapper.mapToDto(funiversityRepositoryService.getCourseById(id));
    }



}
