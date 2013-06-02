package simple_gradebook;

import java.util.ArrayList;

public class Student {
    private String name;
    private int uid;
    private String IDString;
    private String parentEmail;
    private ArrayList<Attend> attendance;
    

    public Student(String name, String IDString){
        this.name = name;
        this.IDString = IDString;
        attendance = new ArrayList<Attend>();
    }
    
    public int getNumAbsences(){
        int output = 0;
        for(int i = 0; i < attendance.size(); i++){
            if(!attendance.get(i).present){
                output++;
            }
        }
        return output;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getIDString(){
        return this.IDString;
    }
    
    public void setIDString(String IDString){
        this.IDString = IDString;
    }
    
    public int getUID(){
        return this.uid;
    }
    
    public void setUID(int uid){
        this.uid = uid;
    }
    
    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }
    
    public boolean equals(Student student){
        if(this.uid == student.uid){
            return true;
        }
        return false;
        
    }
}
