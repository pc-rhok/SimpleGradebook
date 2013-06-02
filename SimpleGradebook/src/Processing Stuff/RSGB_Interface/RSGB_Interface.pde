import controlP5.*;
ControlP5 cp5;

Group[] views;
PFont font;

void setup() {
  size(640, 480);
  font = createFont("arial", 15);
  cp5 = new ControlP5(this);
  views = new Group[] {
    teacherMenu(), classMenu(), assignmentList(), attendanceList(), attendanceMenu()
    };
    switchView(0);
}

void draw() {
  background(color(200));
}

void keyPressed() {
  int index = int(str(key));
  if (0 <= index && index < views.length)
    switchView(int(str(key)));
}

void switchView(int viewNum) {
  for (int i = 0; i < views.length; i++) {
    if (i == viewNum)
      views[i].setVisible(true);
    else
      views[i].setVisible(false);
  }
}

// Make the buttons work!
void controlEvent(ControlEvent theEvent) {
  //The attendance list
  String name = theEvent.name();
  if (name.equals("attendanceList")) {
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
  } else if (name.equals("backToClass")) {
    switchView(1);
  } else if (name.equals("assignments")) {
    switchView(2);
  } else if (name.equals("backToClassList")) {
    switchView(0);
  } else if (name.equals("attendance")) {
    switchView(3);
  } else if (name.equals("backToClassFromAssignment")) {
    switchView(1);
  } else if (name.equals("backToClassFromAttendance")) {
    switchView(1);
  }
}

