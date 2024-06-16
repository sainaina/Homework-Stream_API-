package ManagementSys.service;

import ManagementSys.exception.CourseNotFoundException;
import ManagementSys.model.Course;
import ManagementSys.repository.CourseRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CourseServiceImpl implements CourseService {

    private static List<Course> courseList = CourseRepository.allCourse();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public List<Course> addNewCourse() {
        System.out.print("[+] Insert course ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("[+] Insert course title: ");
        String title = scanner.nextLine();

        System.out.print("[+] Insert instructor name(s) separated by comma: ");
        String[] instructorNames = scanner.nextLine().split(",");

        System.out.print("[+] Insert course requirements separated by comma: ");
        String[] requirements = scanner.nextLine().split(",");

        System.out.print("[+] Insert course start date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Course newCourse = new Course(id, title, instructorNames, requirements, startDate);
        courseList.add(newCourse);

        System.out.println("[->] Add New Course Successfully!");
        return courseList;
    }

    @Override
    public List<Course> listAllCourses() {
        CourseTable.table(courseList); // Utilize CourseTable to render the course table
        return courseList;
    }

    @Override
    public Course findCourseById(Integer id) throws CourseNotFoundException {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        return courseList.stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .orElseThrow(() -> new CourseNotFoundException("[!] Course not found with ID: " + id));
    }

    @Override
    public Course findCourseByTitle(String title) throws CourseNotFoundException {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }

        return courseList.stream()
                .filter(course -> course.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElseThrow(() -> new CourseNotFoundException("[!] Course not found with title: " + title));
    }

    @Override
    public void removeCourseById(Integer id) throws CourseNotFoundException {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        boolean removed = courseList.removeIf(course -> course.getId()==(id));

        if (!removed) {
            throw new CourseNotFoundException("[!] Course not found with ID: " + id);
        }

        System.out.println("Course with ID " + id + " has been successfully removed.");
    }

}
