package ums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A student registered at the university. Every student receives a unique,
 * 9-digit student id (e.g. "300000001") when it is created.
 */
public class Student extends Person {

    /** Next student number to hand out. Shared by all students. */
    private static int nextStudentNumber = 300000001;

    /** Unique student id. */
    private final String studentId;

    /** Program of study (e.g. "Software Engineering"). */
    private final String program;

    /** Courses the student is registered in. */
    private final List<Course> courses = new ArrayList<>();

    /** Final grades (0 to 100) of the student, indexed by course code. */
    private final Map<String, Integer> grades = new LinkedHashMap<>();

    /**
     * Converts a numeric grade to a letter grade.
     * @param grade A numeric grade from 0 to 100, inclusively.
     * @return A letter grade.
     */
    public static String toLetterGrade(double grade) {
        if (grade >= 90) return "A+";
        if (grade >= 85) return "A";
        if (grade >= 80) return "A-";
        if (grade >= 75) return "B+";
        if (grade >= 70) return "B";
        if (grade >= 65) return "C+";
        if (grade >= 60) return "C";
        if (grade >= 55) return "D+";
        if (grade >= 50) return "D";
        if (grade >= 40) return "E";
        return "F";
    }

    /**
     * Creates a student and assigns it the next available student id.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param program   the program of study
     */
    public Student(String firstName, String lastName, String program) {
        super(firstName, lastName);
        this.studentId = String.valueOf(nextStudentNumber++);
        this.program = program;
    }

    /**
     * Returns the unique student id.
     *
     * @return the student id
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Returns the program of study.
     *
     * @return the program of study
     */
    public String getProgram() {
        return program;
    }

    /**
     * Adds a course to the list of courses this student is registered in.
     * This method is called by {@link Course#registerStudent(Student)}.
     *
     * @param course the course
     */
    void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Indicates whether the student is registered in the course with the given code.
     *
     * @param courseCode the course code
     * @return true if the student is registered in the course
     */
    public boolean isRegisteredIn(String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equalsIgnoreCase(courseCode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a read-only view of the courses the student is registered in.
     *
     * @return the registered courses
     */
    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    /**
     * Returns the list of registered courses, one course per line.
     *
     * @return the formatted list of courses
     */
    private String getCoursesList() {
        if (courses.isEmpty()) {
            return "    (none)\n";
        }
        StringBuilder sb = new StringBuilder();
        for (Course course : courses) {
            sb.append("    - ").append(course.getCode())
              .append(": ").append(course.getDescription()).append('\n');
        }
        return sb.toString();
    }

    /**
     * Records the final grade (0 to 100 inclusively) of the student
     * in a course. Recording a grade for a course that already has one replaces it.
     * 
     * @throws IllegalArgumentException if the grade is out of range or if the student is not registered in the course.
     */
    public void addGrade(String courseCode, int grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        if (!isRegisteredIn(courseCode)) {
            throw new IllegalArgumentException("Student " + getFullName() + " is not registered in course " + courseCode + ".");
        }
        grades.put(courseCode, grade);
    }

    /**
     * @return the average of the recorded grades, or 0.0 if no grade has been recorded.
     */
    public double getAverage() {
        if (grades.isEmpty()) return 0.0;

        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }

    /**
     * @return the student's transcript where each graded course is represented
     * on a separate line followed by the average.
     */
    public String getTranscript() {
        if (grades.isEmpty()) return "\t(none)\n";

        StringBuilder transcript = new StringBuilder();
        for (String course : grades.keySet()) {
            int grade = grades.get(course);
            transcript
                .append("\t- ")
                .append(course)
                .append(": ")
                .append(grade)
                .append(" (")
                .append(toLetterGrade(grade))
                .append(")\n");
        }
        return null;
    }

    /**
     * Returns a multi-line description of the student.
     *
     * @return the string representation of the student
     */
    @Override
    public String toString() {
        return "Student " + getFullName() + " (Student ID: " + studentId + ")\n"
                + "  Program: " + program + "\n"
                + "  Registered courses:\n"
                + getCoursesList()
                + "  Transcript:\n"
                + getTranscript();
    }
}
