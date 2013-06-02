package simple_gradebook;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        GradeBook gb = new GradeBook();
        
        Student billy = new Student("Billy","Bob","MOM@MOM.com");
        Student sally = new Student("Sally","Salamander","DAD@DAD.com");
        Student sanjay = new Student("Sanjay","TheNireSpire","UNCLE@UNCLECOM");
        
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
        
        Assignment project = new Assignment("do work", 3, ++fun.assignID);
        
        fun.addAssignment(project);
        
        fun.inputGrade(sally, project, 99);
        
        System.out.println(fun.printReportCard(sally));
        
        JSONHelper jsonHelper = new JSONHelper();
        jsonHelper.storeToJSON(gb);
        
        GradeBook gradeBookImported = jsonHelper.getFromJSON();
        System.out.println(gradeBookImported.toString());
        
        System.out.println(gradeBookImported.courses.get(0).printReportCard(sally));
        
        

    }
}
