package simple_gradebook;

public class Student {
    private String name;
    private int uid;
    private String IDString;
    private String parentEmail;
    

    public Student(String name, String IDString){
        this.name = name;
        this.IDString = IDString;
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
