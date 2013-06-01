package simple_gradebook;

import java.util.ArrayList;

public class Course {
    String name;
    String teacher;
    private int courseID;
    ArrayList<Assignment> assignments;
    ArrayList<Attend> attendance;
    ArrayList<Student> students;
    float[] weights;
    
    static int studentID = 0;
    
    public Course(String name, String teacher, float[] weights){
           this.name = name;
           this.teacher = teacher;
           
           this.weights = new float[6];
           
           
           for(int i = 0; i < weights.length; i ++){
               this.weights[i] = weights[i];
           }
           
           this.assignments = new ArrayList<Assignment>();
           this.attendance = new ArrayList<Attend>();
           this.students = new ArrayList<Student>();
    }
    
    public void addStudent(Student student){
        this.students.add(student);
        student.setUID(++studentID);
    }
    
    public void removeStudent(Student student){
        
        ///TO DOUBLE FOR LOOP TO REMOVE GRADES
        
        for(int i = 0; i < assignments.size(); i++){
            if(asignment.get(i).student.equals(student)){
                grades.remove(i);
            }
        }
        this.students.remove(student);
    }
    
    public boolean equals(Course course){
        if(this.courseID == course.courseID){
            return true;
        }
        return false;
    }
    
    public void setCourseID(int id){
        this.courseID = id;
    }
    
    public int getCourseID(){
        return this.courseID;
    }
}
