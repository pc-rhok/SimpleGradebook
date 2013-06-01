package simple_gradebook;

import java.util.ArrayList;

public class Course {
    private String name;
    private String teacher;
    
    private ArrayList<Assignment> assignments;
    private ArrayList<Attend> attendance;
    private ArrayList<Student> students;
    private ArrayList<Grade> grades;

    public float[] weights;
    
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
           this.grades = new ArrayList<Grade>();
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
        assignments.add(assign);
    }
    
    public void inputGrade(Student student, Assignment project, float value){
        grades.add(new Grade(student,value, weights[project.getType()]));
    }
    
    public boolean equals(Course course){
        if(this.courseID == course.courseID){
            return true;
        }
        return false;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public ArrayList<Attend> getAttendance() {
        return attendance;
    }

    public void setAttendance(ArrayList<Attend> attendance) {
        this.attendance = attendance;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public float[] getWeights() {
        return weights;
    }

    public void setWeights(float[] weights) {
        this.weights = weights;
    }

    public static int getStudentID() {
        return studentID;
    }

    public static void setStudentID(int studentID) {
        Course.studentID = studentID;
    }

    public static int getAssignID() {
        return assignID;
    }

    public static void setAssignID(int assignID) {
        Course.assignID = assignID;
    }
    
    public int getCourseID(){
        return courseID;
    }
    
    public void setCourseID(int id){
        this.courseID = id;
    }
    
}
