import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 
import java.util.HashMap; 
import java.util.Date; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class RSGB_Interface extends PApplet {


ControlP5 cp5;

Group[] views;

public void setup() {
  size(640, 480);
  cp5 = new ControlP5(this);
  views = new Group[] {
    teacherMenu(), classMenu(), assignmentList(), attendanceList(), attendanceMenu(), assignment(), 
    editAttendance(), studentList()
    };
    switchView(5);
}

public void draw() {
  background(color(200));
}

public void keyPressed() {
  int index = PApplet.parseInt(str(key));
  if (0 <= index && index < views.length)
    switchView(PApplet.parseInt(str(key)));
}

public void switchView(int viewNum) {
  for (int i = 0; i < views.length; i++) {
    if (i == viewNum)
      views[i].setVisible(true);
    else
      views[i].setVisible(false);
  }
}

// Make the buttons work!
public void controlEvent(ControlEvent theEvent) {
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
      item.setColorBackground(color(0xffff0000));
    }
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
  }
}

public Group assignment() {
  // Set up the list of students
  Group g = cp5.addGroup("assignment");
  // The back button
  Button back = cp5.addButton("backToAssignmentListFromAssignment")
    .setValue(0)
      .setSize(100, 50)
        .setPosition(0, 0)
          .setLabel("Back")
            .setGroup(g);
  // Assignment Name
  Textfield assName = cp5.addTextfield("assignmentName")
    .setPosition(20, 100)
      .setSize(200, 40)
        .setFocus(true)
          .setColor(color(255, 0, 0))
            .setLabel("Assignment Name")
              .setFocus(false)
                .setGroup(g);
  assName.getCaptionLabel().setColor(color(0));
  // Assignment Total Points
  Textfield assPoints = cp5.addTextfield("assignmentPoints")
    .setPosition(20, 220)
      .setSize(200, 40)
        .setFocus(true)
          .setColor(color(255, 0, 0))
            .setLabel("Points Available")
              .setFocus(false)
                .setGroup(g);
  assPoints.getCaptionLabel().setColor(color(0));
  // Assignment type
  DropdownList assType = cp5.addDropdownList("assignmentType")
    .setPosition(20, 200)
      .setSize(200, 200)
        .setGroup(g)
          .setLabel("Assignment Type");
  assType.captionLabel().style().marginTop = 3;
  assType.captionLabel().style().marginLeft = 3;
  assType.valueLabel().style().marginTop = 3;
  assType.setItemHeight(30);
  assType.setBarHeight(30);
  assType.getCaptionLabel().setColor(color(220));
  assType.addItem("Homework", 0);
  assType.addItem("Classwork", 1);
  assType.addItem("Quiz", 2);
  assType.addItem("Test", 3);
  assType.addItem("Project", 4);
  assType.addItem("Final Exam", 5);
  // Grade entry
  ListBox students = cp5.addListBox("gradeEntryList")
    .setPosition(.9f*width/2, 50)
      .setSize(width/2, height-110)
        .setItemHeight(30)
          .setBarHeight(30)
            .setColorBackground(color(255, 128))
              .setColorActive(color(0))
                .setColorForeground(0xff246076)
                  .setScrollbarWidth(20);
  students.captionLabel().set("Students");
  students.captionLabel().setColor(color(0));
  students.captionLabel().style().marginTop = 3;
  students.valueLabel().style().marginTop = 3;
  for (int i = 0; i < studentNames.length; i++) {
    ListBoxItem lbi = students.addItem(studentNames[i], i);
    lbi.setColorBackground(color(50));
  }
  students.setGroup(g);

  return g;
}

String[] assignmentNames = {
  "a1", "a2", "a3", "a4", "a5", "a6", "a7"
};

public Group assignmentList() {
  // Set up the list of classes
  Group g = cp5.addGroup("assignmentList");
  // The back button
  Button back = cp5.addButton("backToClassFromAssignmentList")
    .setValue(0)
      .setSize(100, 50)
        .setPosition(0, 0)
          .setLabel("Back")
            .setGroup(g);
  // The list of assignments
  ListBox classes = cp5.addListBox("listOfAssignments")
    .setPosition(0, 100)
      .setSize(width, height-150)
        .setItemHeight(30)
          .setBarHeight(30)
            .setColorBackground(color(255, 128))
              .setColorActive(color(0))
                .setColorForeground(0xff246076)
                  .setScrollbarWidth(20);
  classes.setGroup(g);

  classes.captionLabel().set("Assignments");
  classes.captionLabel().setColor(color(0));
  classes.captionLabel().style().marginTop = 3;
  classes.valueLabel().style().marginTop = 3;
  for (int i = 0; i < assignmentNames.length; i++) {
    ListBoxItem lbi = classes.addItem(assignmentNames[i], i);
    lbi.setColorBackground(color(50));
  }
  // Set up the button for adding assignments
  Button addAssignment = cp5.addButton("addAssignment")
    .setValue(0)
      .setSize(200, 20)
        .setPosition(width/2-100, height-30)
          .setLabel("Add a New Assignment")
            .setGroup(g);
  return g;
}



String[] studentNames = {
  "alice", "bob", "carol", "dave", "emma", "fred", "gina"
};
HashMap<String, Boolean> attendance = new HashMap<String, Boolean>();

public Group attendanceList() {
  // Set up the list of classes
  for (String name : studentNames) {
    attendance.put(name, true);
  }
  Group g = cp5.addGroup("attendanceView");
  // The back button
  Button back = cp5.addButton("backToClassFromAttendance")
    .setValue(0)
      .setSize(100, 50)
        .setPosition(0, 0)
          .setLabel("Back")
            .setGroup(g);
  ListBox classes = cp5.addListBox("attendanceList")
    .setPosition(0, 100)
      .setSize(width, height-150)
        .setItemHeight(30)
          .setBarHeight(30)
            .setColorBackground(color(128))
              .setColorForeground(0xff246076)
                .setScrollbarWidth(20);
  classes.setGroup(g);

  classes.captionLabel().set("Students");
  classes.captionLabel().setColor(color(0));
  classes.captionLabel().style().marginTop = 3;
  classes.valueLabel().style().marginTop = 3;
  for (int i = 0; i < studentNames.length; i++) {
    ListBoxItem lbi = classes.addItem(studentNames[i], i);
    lbi.setColorBackground(color(50));
  }
  return g;
}
public Group attendanceMenu() {
  // Set up the back button
  Group g = cp5.addGroup("attendanceMenu");
  Button back = cp5.addButton("backToClassView")
    .setValue(0)
      .setSize(100, 50)
        .setPosition(0, 0)
          .setLabel("Back")
            .setGroup(g);
  // Set up the Today's Attendance button
  Button assignments = cp5.addButton("today")
    .setValue(0)
      .setSize(150, 50)
        .setPosition(width/2-75, height/5)
          .setLabel("Today's Attendance")
            .setGroup(g);
  // Set up the Attendance button
  Button attendance = cp5.addButton("history")
    .setValue(0)
      .setSize(150, 50)
        .setPosition(width/2-75, 2*height/5)
          .setLabel("Attendance History")
            .setGroup(g);
  // DONE
  return g;
}

public Group classMenu() {
  // Set up the back button
  Group g = cp5.addGroup("classView");
  Button back = cp5.addButton("backToClassList")
    .setValue(0)
      .setSize(100, 50)
        .setPosition(0, 0)
          .setLabel("Back")
            .setGroup(g);
  // Set up the Assignments button
  Button assignments = cp5.addButton("assignments")
    .setValue(0)
      .setSize(150, 50)
        .setPosition(width/2-75, height/5)
          .setLabel("Assignments")
            .setGroup(g);
  // Set up the Attendance button
  Button attendance = cp5.addButton("attendance")
    .setValue(0)
      .setSize(150, 50)
        .setPosition(width/2-75, 2*height/5)
          .setLabel("Attendance")
            .setGroup(g);
  // Set up the Student Reports button
  Button reports = cp5.addButton("studentReports")
    .setValue(0)
      .setSize(150, 50)
        .setPosition(width/2-75, 3*height/5)
          .setLabel("Student Reports")
            .setGroup(g);
  // Set up the Setup button
  Button dood = cp5.addButton("config")
    .setValue(0)
      .setSize(150, 50)
        .setPosition(width/2-75, 4*height/5)
          .setLabel("Setup")
            .setGroup(g);
  
  // DONE
  return g;
}



Date[] classDates = {new Date(2013, 11, 2), new Date(2013, 11, 3), new Date(2013, 11, 4), new Date(2013, 11, 5), new Date(2013, 11, 6)};

public Group editAttendance() {
  // Set up the back button
  Group g = cp5.addGroup("editAttendance");
  Button back = cp5.addButton("backToAttendanceMenu")
    .setValue(0)
      .setSize(100, 50)
        .setPosition(0, 0)
          .setLabel("Back")
            .setGroup(g);
  
  // The list of students
  ListBox classes = cp5.addListBox("attendingList")
    .setPosition(0, 100)
      .setSize(width, height-110)
        .setItemHeight(30)
          .setBarHeight(30)
            .setColorBackground(color(255, 128))
              .setColorActive(color(0))
                .setColorForeground(0xff246076)
                  .setScrollbarWidth(20);
  classes.setGroup(g);

  classes.captionLabel().set("Edit Attendance");
  classes.captionLabel().setColor(color(0));
  classes.captionLabel().style().marginTop = 3;
  classes.valueLabel().style().marginTop = 3;
  for (int i = 0; i < classDates.length; i++) {
    ListBoxItem lbi = classes.addItem(String.valueOf(classDates[i].getDay()) + "/" + String.valueOf(classDates[i].getMonth()+1) + "/" + String.valueOf(classDates[i].getYear()), i);
    lbi.setColorBackground(color(50));
  }
  // DONE
  return g;
}
public Group studentList() {
  // Set up the list of classes
  Group g = cp5.addGroup("studentList");
  // The back button
  Button back = cp5.addButton("backToClassViewFromStudents")
    .setValue(0)
      .setSize(100, 50)
        .setPosition(0, 0)
          .setLabel("Back")
            .setGroup(g);
  // The list of students
  ListBox classes = cp5.addListBox("studentReportList")
    .setPosition(0, 100)
      .setSize(width, height-110)
        .setItemHeight(30)
          .setBarHeight(30)
            .setColorBackground(color(255, 128))
              .setColorActive(color(0))
                .setColorForeground(0xff246076)
                  .setScrollbarWidth(20);
  classes.setGroup(g);

  classes.captionLabel().set("Students");
  classes.captionLabel().setColor(color(0));
  classes.captionLabel().style().marginTop = 3;
  classes.valueLabel().style().marginTop = 3;
  for (int i = 0; i < studentNames.length; i++) {
    ListBoxItem lbi = classes.addItem(studentNames[i], i);
    lbi.setColorBackground(color(50));
  }
  // Set up the button for adding assignments
  Button addAssignment = cp5.addButton("addStudent")
    .setValue(0)
      .setSize(200, 20)
        .setPosition(width/2-100, height-30)
          .setLabel("Add a New Student")
            .setGroup(g);
  return g;
}


String[] classNames = {"Math","Science","Literature","History"};

public Group teacherMenu() {
  // Set up the list of classes
  Group g = cp5.addGroup("teacherView");
  ListBox classes = cp5.addListBox("classList")
    .setPosition(0, 30)
      .setSize(width, height-50)
        .setItemHeight(30)
          .setBarHeight(30)
            .setColorBackground(color(255, 128))
              .setColorActive(color(0))
                .setColorForeground(0xff246076)
                  .setScrollbarWidth(20);
  classes.setGroup(g);

  classes.captionLabel().set("My Classes");
  classes.captionLabel().setColor(color(0));
  classes.captionLabel().style().marginTop = 3;
  classes.valueLabel().style().marginTop = 3;
  for (int i = 0; i < classNames.length; i++) {
    ListBoxItem lbi = classes.addItem(classNames[i], i);
    lbi.setColorBackground(color(50));
  }
  // Set up the button for adding classes
  Button addClass = cp5.addButton("addClass");
  addClass.setValue(0);
  addClass.setSize(200, 20);
  addClass.setPosition(width/2-100, height-50);
  addClass.setLabel("Add a New Class");
  addClass.setGroup(g);
  return g;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "RSGB_Interface" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
