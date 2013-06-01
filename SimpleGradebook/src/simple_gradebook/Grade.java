package simple_gradebook;

public class Grade {
    Student student;
    int UID;
    float value;
    int weight;
    
    public Grade(Student student, float value, int weight){
        this.student = student;
        this.value = value;
        this.weight = weight;
    }
}
