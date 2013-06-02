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

  public Course(String name, String teacher, float[] weights) {
    this.name = name;
    this.teacher = teacher;

    this.weights = weights;

    this.assignments = new ArrayList<Assignment>();
    this.attendance = new ArrayList<Attend>();
    this.students = new ArrayList<Student>();
    this.grades = new ArrayList<Grade>();
  }

  /**
   * Adds a student to the students array.
   * Sets the UID of the student by incrementing the static global variable
   * @param student
   */
  public void addStudent(Student student) {
    this.students.add(student);
    student.setUID(++studentID);
  }

  /**
   * Removes student from the students array.
   * TODO: REMOVE ASSOCIATED GRADES
   * @param student
   */
  public void removeStudent(Student student) {

    this.students.remove(student);
  }

  /**
   * Adds an assignment to the assignments array
   * @param assign
   */
  public void addAssignment(Assignment assign) {
    assignments.add(assign);
  }

  /**
   * constructs a Grade object and adds it to both this Assignment object as well as the student object array
   * @param student
   * @param project
   * @param value
   */
  public void inputGrade(Student student, Assignment project, float value) {
    Grade toInput = new Grade(student, project, value, weights[project.getType()]);
    student.getGrades().add(toInput);
    grades.add(toInput);
  }

  /*
     * Returns the average grade of the Course
   */
  public float getAverageGrade() {
    int output = 0;
    for (int i = 0; i < grades.size(); i++) {
      output += grades.get(i).getValue();
    }

    return output;
  }

  /*
     * Returns an ArrayList of assignments that a student has completed
   */
  public ArrayList<Assignment> getStudentAssignments(Student student) {
    ArrayList<Assignment> output = new ArrayList<Assignment>();
    for (int i = 0; i < student.getGrades().size(); i++) {
      output.add(student.getGrades().get(i).getAssignment());
    }       
    return output;
  }
  
  public void addAttendance(Student student, boolean status){
      Attend attend = new Attend(this, student, status);
      this.attendance.add(attend);
  }

  /**
   * prints a report card for a student listing their name, course, absences, assignments, grades, individual average
   * and class average.
   * @param student
   * @return
   */
  public String printReportCard(Student student) {
    StringBuilder str = new StringBuilder();

    str.append(student.getName() + "\n");
    str.append(this.name + "\n");
    str.append(student.getNumAbsences() + "\n");

    ArrayList<Assignment> assigns = getStudentAssignments(student);
    ArrayList<Grade> grds = student.getGrades();

    float gradeSum = 0;
    int numGrades = 0;

    for (int i = 0; i < grds.size(); i++) {
      str.append(assigns.get(i).getName() + "-----------------");
      str.append(grds.get(i).getAssignment().getName() + "\n");
      str.append(grds.get(i).getValue() + "\n");
      gradeSum +=grds.get(i).getValue();
      numGrades++;
    }

    str.append(gradeSum/numGrades + "\n");
    str.append(getAverageGrade() + "\n");


    return str.toString();
  }

  public boolean equals(Course course) {
    if (this.courseID == course.courseID) {
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

  public int getCourseID() {
    return courseID;
  }

  public void setCourseID(int id) {
    this.courseID = id;
  }
}

