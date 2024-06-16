package ManagementSys.service;

import ManagementSys.exception.CourseNotFoundException;
import ManagementSys.model.Course;
import java.util.List;

public interface CourseService {
    List<Course> addNewCourse();
    List<Course> listAllCourses();
    Course findCourseById(Integer id) throws CourseNotFoundException;
    Course findCourseByTitle(String title) throws CourseNotFoundException ;
    void removeCourseById(Integer id) throws CourseNotFoundException;
}