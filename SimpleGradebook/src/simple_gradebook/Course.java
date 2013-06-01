package simple_gradebook;

import java.util.ArrayList;

public class Course {
    String name;
    String teacher;
    ArrayList<Grade> grades;
    ArrayList<Attend> attendance;
    ArrayList<Student> students;
    float[] weights;
    
    public Course(String name, String teacher, float[] weights){
           this.name = name;
           this.teacher = teacher;
           
           this.weights = new float[6];
           
           
           for(int i = 0; i < weights.length; i ++){
               this.weights[i] = weights[i];
           }
           
           this.grades = new ArrayList<Grade>();
           this.attendance = new ArrayList<Attend>();
           this.students = new ArrayList<Student>();
    }
    
    public void addStudent(Student student){
        this.students.add(student);
        student.setUID(students.size());
    }
    
    public void removeStudent(Student student){
        this.students.remove(student);
    }
}
