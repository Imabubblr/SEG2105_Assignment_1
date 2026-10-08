/**
 * Name: Edward Yang
 * Student ID: 300508825
 */
package ums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A course offered by the university. A course has at most one professor and
 * a limited number of seats for students.
 */
public class Course {

    /** Unique course code (e.g. "SEG2105"). */
    private final String code;

    /** Short description of the course. */
    private final String description;

    /** Maximum number of students that can be registered. */
    private final int capacity;

    /** Professor teaching the course, or null if none is assigned yet. */
    private Professor professor;

    /** Teaching assistants teaching the course. */
    private final List<TeachingAssistant> teachingAssistants = new ArrayList<>();

    /** Students registered in the course. */
    private final List<Student> students = new ArrayList<>();

    /**
     * Creates a course.
     *
     * @param code        the unique course code
     * @param description the course description
     * @param capacity    the maximum number of students
     * @throws IllegalArgumentException if the capacity is not positive
     */
    public Course(String code, String description, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("The capacity of a course must be positive.");
        }
        this.code = code.toUpperCase();
        this.description = description;
        this.capacity = capacity;
    }

    /**
     * Returns the course code.
     *
     * @return the course code
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the course description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the maximum number of students.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns the professor teaching the course.
     *
     * @return the professor, or null if none is assigned
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * Sets the professor teaching the course.
     *
     * @param professor the professor
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * Returns a read-only view of the registered teaching assistants.
     *
     * @return the registered teaching assistants 
     */
    public List<TeachingAssistant> getTeachingAssistants() {
        return Collections.unmodifiableList(teachingAssistants);
    }

    /**
     * Returns a read-only view of the registered students.
     *
     * @return the registered students
     */
    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    /**
     * Registers a student in the course.
     *
     * @param student the student to register
     * @throws IllegalStateException if the course is full or the student is already registered
     */
    public void registerStudent(Student student) {
        if (students.contains(student)) {
            throw new IllegalStateException(student.getFullName()
                    + " is already registered in " + code + ".");
        }
        if (students.size() >= capacity) {
            throw new IllegalStateException(code + " is full.");
        }
        students.add(student);
        student.addCourse(this);
    }

    /**
     * Returns a multi-line description of the course.
     *
     * @return the string representation of the course
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(code).append(" - ").append(description).append('\n');
        sb.append("  Enrolment: ").append(students.size()).append('/').append(capacity).append('\n');
        sb.append("  Professor: ")
          .append(professor == null ? "(none)" : professor.getFullName()).append('\n');
        sb.append("  TAs: ");

        // Credits for Collectors.joining: https://stackoverflow.com/a/22577565
        sb.append(
            teachingAssistants.isEmpty()
                ? "(none)"
                : teachingAssistants
                    .stream()
                    .map(ta -> ta.getFullName())
                    .collect(Collectors.joining(", "))
        );

        sb.append("\n  Students:\n");
        if (students.isEmpty()) {
            sb.append("    (none)\n");
        }
        for (Student student : students) {
            sb.append("    - ").append(student.getStudentId())
              .append(' ').append(student.getFullName()).append('\n');
        }
        return sb.toString();
    }

    /**
     * Assigns a teaching assistant to the course.
     *
     * @param ta the teaching assistant to register
     * @throws IllegalStateException if the teaching assistant is already registered, or 
     * the course already has the maximum number of teaching assistants.
     */
    public void addTeachingAssistant(TeachingAssistant ta) {
        if (teachingAssistants.contains(ta)) {
            throw new IllegalStateException(
                "Teaching assistant " + ta.getFullName() + " is already instructing course " + code + "."
            );
        }
        if (teachingAssistants.size() >= TeachingAssistant.MAX_COURSES) {
            throw new IllegalStateException(
                "Courses can only be assigned up to a maximum of "
                    + TeachingAssistant.MAX_COURSES
                    + " teaching assistants."
            );
        }
        teachingAssistants.add(ta);
    }
}
