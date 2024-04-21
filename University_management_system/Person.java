package University_management_system;

import java.util.ArrayList;
import java.util.List;

abstract class Person {
    String name;
    int age;
    String ID;

    public Person(String name, int age, String ID) {
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

    // Getters and setters for fields
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for ID
    public String getID() {
        return ID;
    }

    // Setter for ID
    public void setID(String ID) {
        this.ID = ID;
    }
}

interface IManageable {
    void add(Object entity);

    void remove(Object entity);

    void update(Object entity);
}

class Student extends Person {
    double GPA;
    List<Course> coursesEnrolled;

    public Student(String name, int age, String ID, double GPA) {
        super(name, age, ID);
        this.GPA = GPA;
        this.coursesEnrolled = new ArrayList<>();
    }

    // Methods to manipulate coursesEnrolled
    public void enrollInCourse(Course course) {
        if (!coursesEnrolled.contains(course)) {
            coursesEnrolled.add(course);
            System.out.println(name + " enrolled in course: " + course.courseName);
        } else {
            System.out.println(name + " is already enrolled in course: " + course.courseName);
        }
    }

    // Method to withdraw from a course
    public void withdrawFromCourse(Course course) {
        if (coursesEnrolled.contains(course)) {
            coursesEnrolled.remove(course);
            System.out.println(name + " withdrew from course: " + course.courseName);
        } else {
            System.out.println(name + " is not enrolled in course: " + course.courseName);
        }
    }

    // Method to get the list of courses enrolled
    public List<Course> getCoursesEnrolled() {
        return coursesEnrolled;
    }
}

class Faculty extends Person {
    String department;
    List<Course> coursesTaught;

    public Faculty(String name, int age, String ID, String department) {
        super(name, age, ID);
        this.department = department;
        this.coursesTaught = new ArrayList<>();
    }

    // Methods to manipulate coursesTaught
    public void addCourseTaught(Course course) {
        if (!coursesTaught.contains(course)) {
            coursesTaught.add(course);
            System.out.println(name + " is now teaching course: " + course.courseName);
        } else {
            System.out.println(name + " is already teaching course: " + course.courseName);
        }
    }

    // Method to remove a course from the list of courses taught
    public void removeCourseTaught(Course course) {
        if (coursesTaught.contains(course)) {
            coursesTaught.remove(course);
            System.out.println(name + " stopped teaching course: " + course.courseName);
        } else {
            System.out.println(name + " is not teaching course: " + course.courseName);
        }
    }

    // Method to get the list of courses taught
    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }
}

class Course {
    String courseName;
    String courseCode;
    Faculty assignedFaculty;
    List<Student> enrolledStudents;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrolledStudents = new ArrayList<>();
    }

    // Methods to manipulate enrolledStudents and assignedFaculty
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            System.out.println(student.name + " enrolled in " + courseName);
        } else {
            System.out.println(student.name + " is already enrolled in " + courseName);
        }
    }

    // Method to remove a student from the course
    public void removeStudent(Student student) {
        if (enrolledStudents.contains(student)) {
            enrolledStudents.remove(student);
            System.out.println(student.name + " removed from " + courseName);
        } else {
            System.out.println(student.name + " is not enrolled in " + courseName);
        }
    }

    // Method to assign a faculty member to the course
    public void assignFaculty(Faculty faculty) {
        this.assignedFaculty = faculty;
        System.out.println(faculty.name + " assigned to teach " + courseName);
    }

    // Method to remove the assigned faculty from the course
    public void removeFaculty() {
        if (assignedFaculty != null) {
            System.out.println(assignedFaculty.name + " removed from teaching " + courseName);
            assignedFaculty = null;
        } else {
            System.out.println("No faculty assigned to " + courseName);
        }
    }
}

class Department {
    String departmentName;
    List<Course> courses;
    List<Faculty> facultyMembers;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.courses = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    // Methods to manipulate courses and facultyMembers
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println(course.courseName + " added to department " + departmentName);
        } else {
            System.out.println(course.courseName + " is already part of department " + departmentName);
        }
    }

    // Method to remove a course from the department
    public void removeCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            System.out.println(course.courseName + " removed from department " + departmentName);
        } else {
            System.out.println(course.courseName + " is not part of department " + departmentName);
        }
    }

    // Method to add a faculty member to the department
    public void addFaculty(Faculty faculty) {
        if (!facultyMembers.contains(faculty)) {
            facultyMembers.add(faculty);
            System.out.println(faculty.name + " added to department " + departmentName);
        } else {
            System.out.println(faculty.name + " is already part of department " + departmentName);
        }
    }

    // Method to remove a faculty member from the department
    public void removeFaculty(Faculty faculty) {
        if (facultyMembers.contains(faculty)) {
            facultyMembers.remove(faculty);
            System.out.println(faculty.name + " removed from department " + departmentName);
        } else {
            System.out.println(faculty.name + " is not part of department " + departmentName);
        }
    }
}

class UniversityManagement implements IManageable {
    List<Student> students;
    List<Faculty> faculties;
    List<Course> courses;
    List<Department> departments;

    public UniversityManagement() {
        this.students = new ArrayList<>();
        this.faculties = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof Student) {
            students.add((Student) entity);
        } else if (entity instanceof Faculty) {
            faculties.add((Faculty) entity);
        } else if (entity instanceof Course) {
            courses.add((Course) entity);
        } else if (entity instanceof Department) {
            departments.add((Department) entity);
        } else {
            // Handle unsupported entity type
            System.out.println("Unsupported entity type.");
        }
    }

    @Override
    public void remove(Object entity) {
        if (entity instanceof Student) {
            students.remove(entity);
        } else if (entity instanceof Faculty) {
            faculties.remove(entity);
        } else if (entity instanceof Course) {
            courses.remove(entity);
        } else if (entity instanceof Department) {
            departments.remove(entity);
        } else {
            // Handle unsupported entity type
            System.out.println("Unsupported entity type.");
        }
    }

    @Override
    public void update(Object entity) {
        if (entity instanceof Student) {
            // Implement update logic for student
        } else if (entity instanceof Faculty) {
            // Implement update logic for faculty
        } else if (entity instanceof Course) {
            // Implement update logic for course
        } else if (entity instanceof Department) {
            // Implement update logic for department
        } else {
            // Handle unsupported entity type
            System.out.println("Unsupported entity type.");
        }
    }

    public void enrollStudentInCourse(Student student, Course course) {
        if (students.contains(student) && courses.contains(course)) {
            if (!course.enrolledStudents.contains(student)) {
                course.enrolledStudents.add(student);
                System.out.println(student.name + " enrolled in " + course.courseName);
            } else {
                System.out.println(student.name + " is already enrolled in " + course.courseName);
            }
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public void assignFacultyToCourse(Faculty faculty, Course course) {
        if (faculties.contains(faculty) && courses.contains(course)) {
            course.assignedFaculty = faculty;
            System.out.println(faculty.name + " assigned to teach " + course.courseName);
        } else {
            System.out.println("Faculty or course not found.");
        }
    }

    public void addCourseToDepartment(Course course, Department department) {
        if (courses.contains(course) && departments.contains(department)) {
            department.courses.add(course);
            System.out.println(course.courseName + " added to department " + department.departmentName);
        } else {
            System.out.println("Course or department not found.");
        }
    }

}

class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}
