package ManagementSys.service;

import ManagementSys.exception.CourseNotFoundException;
import ManagementSys.model.Course;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseService courseService = new CourseServiceImpl();
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("\n======================WELCOME TO COURSE MANAGEMENT SYSTEM=======================\n");

        do {
            System.out.println("1. Add a new course");
            System.out.println("2. List all courses");
            System.out.println("3. Find a course by ID");
            System.out.println("4. Find a course by title");
            System.out.println("5. Remove a course by ID");
            System.out.println("6. Exit");
            System.out.print("[+] Insert option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    courseService.addNewCourse();
                    break;
                case 2:
                    courseService.listAllCourses();
                    break;
                case 3:
                    System.out.print("[+] Insert course ID: ");
                    int courseId = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Course foundCourse = courseService.findCourseById(courseId);
                        System.out.println("Course found by ID:");
                        CourseTable.table(List.of(foundCourse));
                    } catch (CourseNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("[+] Insert course title: ");
                    String courseTitle = scanner.nextLine();

                    try {
                        Course foundCourse = courseService.findCourseByTitle(courseTitle);
                        System.out.println("Course found by title:");
                        CourseTable.table(List.of(foundCourse));
                    } catch (CourseNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("[+] Insert course ID to remove: ");
                    courseId = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        courseService.removeCourseById(courseId);
                    } catch (CourseNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("[!] Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}