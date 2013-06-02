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
    
    /**
     * Adds a course to the gradebook (there really should be only one)
     * Sets a course ID based on the number of the instance
     * @param course This parameter is awesome!
     */
    public void addCourse(Course course){
        course.setCourseID(++courseCounter);
        this.courses.add(course);
    }
    
    /**
     * Don't use this. It really does nothing useful. I should really take it out.
     */
    public String toString(){
    	 String output = ""; 
    	
    	for(int i = 0; i < courses.size(); i++)
    	{
    		ArrayList<Student> students = courses.get(i).getStudents();
    		for(int j = 0; j <students.size(); j++)
    		{
    			output = output + students.get(j).getName();
    		}
    	}
        return output;
    }
}
