package University_management_system;

public class Main {
    public static void main(String[] args) {
        // Create an instance of UniversityManagement
        UniversityManagement managementSystem = new UniversityManagement();

        // Create some students
        Student student1 = new Student("John Doe", 20, "S001", 3.8);
        Student student2 = new Student("Alice Smith", 22, "S002", 3.5);

        // Add students to the management system
        managementSystem.students.add(student1);
        managementSystem.students.add(student2);

        // Create some faculty members
        Faculty faculty1 = new Faculty("Dr. Smith", 45, "F001", "Computer Science");
        Faculty faculty2 = new Faculty("Prof. Johnson", 50, "F002", "Mathematics");

        // Add faculty members to the management system
        managementSystem.faculties.add(faculty1);
        managementSystem.faculties.add(faculty2);

        // Create some courses
        Course course1 = new Course("Introduction to Programming", "CS101");
        Course course2 = new Course("Calculus I", "MATH101");

        // Add courses to the management system
        managementSystem.courses.add(course1);
        managementSystem.courses.add(course2);

        // Enroll students in courses
        course1.enrolledStudents.add(student1);
        course1.enrolledStudents.add(student2);

        // Assign faculty to courses
        course1.assignedFaculty = faculty1;
        course2.assignedFaculty = faculty2;

        // Create a department
        Department department = new Department("Computer Science");

        // Add courses and faculty to the department
        department.courses.add(course1);
        department.courses.add(course2);
        department.facultyMembers.add(faculty1);
        department.facultyMembers.add(faculty2);

        // Add the department to the management system
        managementSystem.departments.add(department);

    }
}
