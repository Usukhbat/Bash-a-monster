import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String address;
    private ArrayList<Course> courses;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addCourseGrade(Course course, int grade) {
        if (courses.contains(course)) {
            course.addStudentGrade(this, grade);
        } else {
            System.out.println(name + " is not enrolled in the course " + course.getName());
        }
    }

    public void printGrades() {
        System.out.println("Grades for " + name + ":");
        for (Course course : courses) {
            System.out.println(course.getName() + ": " + course.getStudentGrade(this));
        }
    }

    public double printAverageGrade() {
        if (courses.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (Course course : courses) {
            sum += course.getStudentGrade(this);
        }

        return (double) sum / courses.size();
    }

    @Override
    public String toString() {
        return name + " (" + address + ")";
    }
}

class Course {
    private String name;
    private Teacher teacher;
    private ArrayList<Student> students;
    private ArrayList<Integer> grades;

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        this.students = new ArrayList<>();
        this.grades = new ArrayList<>();
        teacher.addCourse(this);
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStudentGrade(Student student, int grade) {
        if (students.contains(student)) {
            grades.add(grade);
        } else {
            System.out.println(student.getName() + " is not enrolled in the course " + name);
        }
    }

    public int getStudentGrade(Student student) {
        int index = students.indexOf(student);
        if (index != -1 && index < grades.size()) {
            return grades.get(index);
        } else {
            return -1; // Grade not available
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}

class Teacher {
    private String name;
    private ArrayList<Course> courses;

    public Teacher(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Skapa lärare
        Teacher teacher1 = new Teacher("Mr. Smith");
        Teacher teacher2 = new Teacher("Ms. Johnson");

        // Skapa kurser
        Course mathCourse = new Course("Math", teacher1);
        Course historyCourse = new Course("History", teacher2);

        // Skapa elever
        Student student1 = new Student("Liv", "Craafordsväg 12");
        Student student2 = new Student("Annon", "Erehwon 101");

        // Lägg till elever i kurser
        mathCourse.addStudent(student1);
        historyCourse.addStudent(student1);

        mathCourse.addStudent(student2);
        historyCourse.addStudent(student2);

        // Användaren sätter betyg
        System.out.print("Enter grade for " + student1.getName() + " in Math: ");
        int mathGradeStudent1 = scanner.nextInt();
        mathCourse.addStudentGrade(student1, mathGradeStudent1);

        System.out.print("Enter grade for " + student2.getName() + " in Math: ");
        int mathGradeStudent2 = scanner.nextInt();
        mathCourse.addStudentGrade(student2, mathGradeStudent2);

        System.out.print("Enter grade for " + student1.getName() + " in History: ");
        int historyGradeStudent1 = scanner.nextInt();
        historyCourse.addStudentGrade(student1, historyGradeStudent1);

        System.out.print("Enter grade for " + student2.getName() + " in History: ");
        int historyGradeStudent2 = scanner.nextInt();
        historyCourse.addStudentGrade(student2, historyGradeStudent2);

        // Skriv ut information om elever och deras betyg
        System.out.println("\nStudent Information:");
        System.out.println(student1.toString());
        student1.printGrades();
        System.out.println("Average Grade: " + student1.printAverageGrade());

        System.out.println();

        System.out.println(student2.toString());
        student2.printGrades();
        System.out.println("Average Grade: " + student2.printAverageGrade());

        // Skriv ut alla elever som går på en kurs
        System.out.println("\nStudents in Math Course:");
        for (Student student : mathCourse.getStudents()) {
            System.out.println(student.toString());
        }

        // Skriv ut alla kurser en lärare har
        System.out.println("\nCourses taught by " + teacher1.getName() + ":");
        for (Course course : teacher1.getCourses()) {
            System.out.println(course.getName());
        }

        scanner.close();
    }
}
