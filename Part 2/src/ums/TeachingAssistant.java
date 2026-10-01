package ums;

/**
 * A teaching assistant is an employee who can teach up to {@value #MAX_COURSES} courses at a time.
 */
public class TeachingAssistant extends Instructor {

    /** Maximum number of courses a teaching assistant can teach at a time. */
    public static final int MAX_COURSES = 2;

    /**
     * Creates a teaching assistant.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param salary    the yearly salary
     */
    protected TeachingAssistant(String firstName, String lastName, double salary) {
        super(firstName, lastName, salary);
    }

    /**
     * Returns the maximum number of courses a teaching assistant can teach at a time.
     *
     * @return {@value #MAX_COURSES}
     */
    @Override
    public int getMaxCourses() {
        return MAX_COURSES;
    }

    /**
     * Returns a multi-line description of the teaching assistant.
     *
     * @return the string representation of the teaching assistant
     */
    @Override
    public String toString() {
        return "TeachingAssistant" + getFullName() + " (Employee ID: " + getEmployeeId() + ")\n"
                + "  Salary: " + getFormattedSalary() + "\n"
                + "  Courses (" + getCourses().size() + "/" + getMaxCourses() + "):\n"
                + getCoursesList();
    }
}
