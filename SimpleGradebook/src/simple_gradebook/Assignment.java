package simple_gradebook;

import java.util.ArrayList;

public class Assignment {
    public String name;
    ArrayList<Grade> grades;
    private int assignID;
    
    public Assignment(){
        grades = new ArrayList<Grade>();
    }
    
    public void setAssignID(int id){
        this.assignID = id;
    }
    
    public int getAssignID(){
        return assignID;
    }
}
