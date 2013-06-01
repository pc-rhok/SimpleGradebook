package simple_gradebook;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        GradeBook gb = new GradeBook();
        
        Student billy = new Student("Billy","Bob");
        Student sally = new Student("Sally","Salamander");
        Student sanjay = new Student("Sanjay","TheNireSpire");
        
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(billy);
        students.add(sally);
        students.add(sanjay);
        
        float[] weights = new float[]{1,2,3,4,5,6};
        
        Course fun = new Course("fun","Mr.Awesome",weights);
        
        gb.addCourse(fun);
        
        for(int i = 0; i < students.size(); i++){
            fun.addStudent(students.get(i));
        }
        
        Assignment project = new Assignment();
        
        JSONHelper jsonHelper = new JSONHelper();
        jsonHelper.storeToJSON(gb);
    
    }
}
