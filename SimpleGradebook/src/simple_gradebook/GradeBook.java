package simple_gradebook;

import java.util.ArrayList;

public class GradeBook {
    int numCourses;
    int numStudents;
    static int courseCounter = 0;
    
    ArrayList<Course> courses;
    
    public GradeBook(){
        this.courses = new ArrayList<Course>();
    }
    
    public void addCourse(Course course){
        course.setCourseID(++courseCounter);
        this.courses.add(course);
    }
}
