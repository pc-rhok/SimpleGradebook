import java.util.HashMap;
HashMap<String, Integer> grades = new HashMap<String, Integer>();
int selectedGrade = 0;

Group assignment() {
  // Set up the list of students
  Group g = cp5.addGroup("assignment");
  for (String name : studentNames) {
    grades.put(name, -1);
  }
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
          .setColor(color(255))
            .setLabel("Assignment Name")
              .setFocus(false)
                .setGroup(g);
  assName.getCaptionLabel().setColor(color(0));
  // Assignment Total Points
  Textfield assPoints = cp5.addTextfield("assignmentPoints")
    .setPosition(20, 170)
      .setSize(200, 40)
        .setFocus(true)
          .setColor(color(255))
            .setLabel("Points Available")
              .setFocus(false)
                .setGroup(g);
  assPoints.getCaptionLabel().setColor(color(0));

  // Assignment type
  DropdownList assType = cp5.addDropdownList("assignmentType")
    .setPosition(20, 270)
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
    .setPosition(.9*width/2, 50)
      .setSize(width/2, height-110)
        .setItemHeight(30)
          .setBarHeight(30)
            .setColorBackground(color(255, 128))
              .setColorActive(color(0))
                .setColorForeground(#246076)
                  .setScrollbarWidth(20);
  students.captionLabel().set("Students");
  students.captionLabel().setColor(color(0));
  students.captionLabel().style().marginTop = 3;
  students.valueLabel().style().marginTop = 3;
  updateGrades();
  students.setGroup(g);

  //Grade Input Field
  Textfield inputPoints = cp5.addTextfield("gradeInput")
    .setPosition(.9*width/2, height-70).setSize(200, 40)
      .setFocus(true)
        .setColor(color(255))
          .setLabel("Points")
            .setFocus(false)
              .setGroup(g);
  inputPoints.getCaptionLabel().setColor(color(0));
  //Average Grade
  Textarea average = cp5.addTextarea("txt")
    .setPosition(20, 350)
      .setSize(200, 50)
        .setLineHeight(14)
          .setColor(color(50))
            .setColorBackground(color(0, 100))
              .setColorForeground(color(255, 100))
                .setText("AVERAGE GRADE: 78")
                  .setGroup(g);
  ;

  return g;
}

void updateGrades() {
  println("SELECTED: "+selectedGrade);
  ListBox students = (ListBox)cp5.get("gradeEntryList");
  for (int i = 0; i < studentNames.length; i++) {
    ListBoxItem lbi;
    if (grades.get(studentNames[i]) >= 0)
      lbi = students.addItem(studentNames[i]+"     ("+grades.get(studentNames[i])+")", i);
    else
      lbi = students.addItem(studentNames[i], i);
    if (i == selectedGrade) {
      lbi.setColorBackground(color(0, 100, 0));
    } else {
      lbi.setColorBackground(color(50));
    }
  }
}

