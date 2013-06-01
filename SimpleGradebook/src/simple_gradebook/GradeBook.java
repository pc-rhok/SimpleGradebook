package simple_gradebook;

import java.util.ArrayList;

public class GradeBook {
    int numCourses;
    int numStudents;
    
    ArrayList<Course> courses;
    
    public GradeBook(){
        this.courses = new ArrayList<Course>();
        
    }
}
