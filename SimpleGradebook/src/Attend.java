import java.util.Date;

public class Attend {
  Course course;
  Student student;
  Date date;
  boolean present;

  public Attend(Course course, Student student, Date date, boolean present) {
    this.course = course;
    this.student = student;
    this.date = date;
    this.present = present;
  }
}

