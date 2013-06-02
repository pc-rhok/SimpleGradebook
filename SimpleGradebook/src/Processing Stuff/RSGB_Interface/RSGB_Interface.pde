import controlP5.*;

ControlP5 cp5;
GradeBook gb = new GradeBook();

Group[] views;

void setup() {
  gb.addCourse(new Course("fun", "mr.awesome", new float[] {
    1, 1, 1, 1, 1, 1
  }
  ));
  size(640, 480);
  cp5 = new ControlP5(this);
  views = new Group[] {
    teacherMenu(), classMenu(), assignmentList(), attendanceList(), attendanceMenu(), assignment(), 
    editAttendance(), studentList(), classConfig()
    };
    switchView(0);
}

void draw() {
  background(color(200));
}

int nStudents = 0;
void switchView(int viewNum) {
  nStudents = 0;
  if (viewNum == 0) loadClassNames();
  for (int i = 0; i < views.length; i++) {
    if (i == viewNum)
      views[i].setVisible(true);
    else
      views[i].setVisible(false);
  }
}

void controlEvent(ControlEvent theEvent) {
  String name = theEvent.name();
  //The gradebook
  if (name.equals("gradeEntryList")) {
    int index = (int)theEvent.group().value();
    String studentName = studentNames[index];
    int grade = grades.get(studentName);
    println(studentName+", "+grade);
    ListBox list = (ListBox)cp5.get("gradeEntryList");
    ListBoxItem oldItem = list.getItem(selectedGrade);
    oldItem.setColorBackground(color(50));
    ListBoxItem item = list.getItem(index);
    item.setColorBackground(color(0, 100, 0));
    Textfield gradeBox = (Textfield)cp5.get("gradeInput");
    if (grades.get(studentName) >= 0)
      gradeBox.setText(str(grades.get(studentName)));
    selectedGrade = index;
    gradeBox.setFocus(true);
  } else if (theEvent.isAssignableFrom(Textfield.class) && name.equals("gradeInput")) {
    ListBox list = (ListBox)cp5.get("gradeEntryList");
    ListBoxItem item = list.getItem(selectedGrade);
    String studentName = studentNames[selectedGrade];
    Textfield gradeBox = (Textfield)cp5.get("gradeInput");
    String rawGrade = gradeBox.getText().replaceAll("\\D", "");
    if (rawGrade.length() == 0) {
      gradeBox.clear();
      grades.put(studentName, -1);
      return;
    }
    int grade = int(rawGrade);
    grades.put(studentName, grade);
    item.setText(studentName+"     ("+grades.get(studentName)+")");
  } else if (name.equals("attendanceList")) {
    //The attendance list 
    int index = (int)theEvent.group().value();
    ListBox list = (ListBox)cp5.get("attendanceList");
    ListBoxItem item = list.getItem(index);
    String studentName = item.getText();
    attendance.put(studentName, !attendance.get(studentName));
    if (attendance.get(studentName)) {
      item.setColorBackground(color(50));
    } else {
      item.setColorBackground(color(#ff0000));
    }
  } else if (name.equals("classList")) {
    switchView(1);
    //Navigation controls:
  } else if (name.equals("backToClass")) {
    switchView(1);
  } else if (name.equals("assignments")) {
    switchView(2);
  } else if (name.equals("backToClassList")) {
    switchView(0);
  } else if (name.equals("attendance")) {
    switchView(4);
  } else if (name.equals("backToClassFromAssignmentList")) {
    switchView(1);
  } else if (name.equals("backToClassFromAttendance")) {
    switchView(4);
  } else if (name.equals("backToAssignmentListFromAssignment")) {
    switchView(2);
  } else if (name.equals("backToClassView")) {
    switchView(1);
  } else if (name.equals("backToAttendanceMenu")) {
    switchView(4);
  } else if (name.equals("backToClassViewFromStudents")) {
    switchView(1);
  } else if (name.equals("today")) {
    switchView(3);
  } else if (name.equals("history")) {
    switchView(6);
  } else if (name.equals("studentReports")) {
    switchView(7);
  } else if (name.equals("addClass")) {
    switchView(8);
  } else if (name.equals("saveClass")) {
    gb.addCourse(newCourse());
    switchView(0);
  } else if (name.equals("cancelClass")) {
    //TODO: Ditch the class.
    switchView(0);
  } else if (name.equals("config")) {
    //TODO: Pull up the options for the specific class
    switchView(8);
  } else if (name.equals("listOfAssignments")) {
    //TODO: Pull up this specific assignment
    switchView(5);
  } else if (name.equals("addStudent")) {
    String studentName = ((Textfield)cp5.get("studentName")).getText();
      ListBox list = (ListBox)cp5.get("masterStudentList");
    list.addItem(studentName, nStudents);
    nStudents++;
  }
}

