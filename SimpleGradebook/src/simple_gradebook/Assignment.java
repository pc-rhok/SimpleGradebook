package simple_gradebook;

import java.util.ArrayList;

public class Assignment {
    private String name;
    private int type;
    

    public ArrayList<Grade> grades;
    private int assignID;
    
    public Assignment(String name, int type, int assignID){
        grades = new ArrayList<Grade>();
        this.name = name;
        this.type = type;
    }
    
    public void setAssignID(int id){
        this.assignID = id;
    }
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public int getAssignID(){
        return assignID;
    }
}
