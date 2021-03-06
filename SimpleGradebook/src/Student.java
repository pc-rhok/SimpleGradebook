import java.util.ArrayList;

public class Student {
  private String name;
  private int uid;
  private String IDString;
  private String parentEmail;
  private ArrayList<Attend> attendance;
  private ArrayList<Grade> grades;

  public Student(String name, String IDString, String parentEmail) {
    this.name = name;
    this.IDString = IDString;
    this.parentEmail = parentEmail;
    attendance = new ArrayList<Attend>();
    grades = new ArrayList<Grade>();
  }

  /**
   * Takes a sum of absences based on the Attendance array
   * @return
   */
  public int getNumAbsences() {
    int output = 0;
    for (int i = 0; i < attendance.size(); i++) {
      if (!attendance.get(i).present) {
        output++;
      }
    }
    return output;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIDString() {
    return this.IDString;
  }

  public void setIDString(String IDString) {
    this.IDString = IDString;
  }

  public int getUID() {
    return this.uid;
  }

  public void setUID(int uid) {
    this.uid = uid;
  }

  public String getParentEmail() {
    return parentEmail;
  }

  public void setParentEmail(String parentEmail) {
    this.parentEmail = parentEmail;
  }

  /*
     * Compares the uid, name and IDString of each student and returns true if they are all the same
   */

  public boolean equals(Student student) {
    if (this.uid == student.uid && this.name.compareTo(student.getName()) == 0 && this.IDString.compareTo(student.getIDString()) == 0) {
      return true;
    }
    return false;
  }

  public ArrayList<Attend> getAttendance() {
    return attendance;
  }

  public void setAttendance(ArrayList<Attend> attendance) {
    this.attendance = attendance;
  }

  public ArrayList<Grade> getGrades() {
    return grades;
  }

  public void setGrades(ArrayList<Grade> grades) {
    this.grades = grades;
  }
}

