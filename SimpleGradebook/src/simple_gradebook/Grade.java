package simple_gradebook;

public class Grade {
    Student student;
    int UID;
    float value;
    float weight;
    
    public Grade(Student student, float value, float weight){
        this.student = student;
        this.value = value;
        this.weight = weight;
    }
}
