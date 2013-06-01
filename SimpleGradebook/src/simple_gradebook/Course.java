package simple_gradebook;

import java.util.ArrayList;

public class Course {
    String name;
    String teacher;
    
    ArrayList<Assignment> assignments;
    ArrayList<Attend> attendance;
    ArrayList<Student> students;
    float[] weights;
    
    private int courseID;
    static int studentID = 0;
    static int assignID = 0;
    
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
        
        for(int i = 0; i < assignments.size(); i++){
            for(int j = 0; j <assignments.get(i).grades.size(); j++){
                if(assignments.get(i).grades.get(j).student.equals(student)){
                    assignments.get(i).grades.remove(j);
                }
            }
        }
        
        this.students.remove(student);
    }
    
    public void addAssignment(Assignment assign){
    }
    
    public void inputGrade(Student student, Assignment project){
        
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
