import java.util.Date;

public class Attend {
  Course course;
  Student student;
  Date date;
  boolean present;

  public Attend(Course course, Student student, boolean present) {
    this.course = course;
    this.student = student;
    this.present = present;
  }
}

