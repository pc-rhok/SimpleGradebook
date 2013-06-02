package simple_gradebook;

public class Grade {
    private Student student;
    private int UID;
    private float value;
    private float weight;
    private Assignment assignment;

    public Grade(Student student, Assignment assignment, float value, float weight){
        this.student = student;
        this.value = value;
        this.weight = weight;
        this.assignment = assignment;
    }
    
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int uID) {
        UID = uID;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
