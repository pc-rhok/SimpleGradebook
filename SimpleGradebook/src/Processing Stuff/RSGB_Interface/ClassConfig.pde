Group classConfig() {
  Group g = cp5.addGroup("classConfig");
  Textfield name = cp5.addTextfield("className")
    .setPosition(10, 10)
      .setSize(150, 30)
        .setColor(color(128))
          .setLabel("Class Name")
            .setGroup(g);
  name.captionLabel().setColor(color(0));
  //Student List
  ListBox students = cp5.addListBox("masterStudentList")
    .setPosition(10, 100)
      .setSize(width/2-20, height-110)
        .setItemHeight(30)
          .setBarHeight(30)
            .setColorBackground(color(255, 128))
              .setColorActive(color(0))
                .setColorForeground(#246076)
                  .setScrollbarWidth(20)
                    .setGroup(g)
                      .setLabel("Students");
  students.captionLabel().setColor(color(0));
  students.captionLabel().style().marginTop = 3;
  students.valueLabel().style().marginTop = 3;
  //Student Name Field
  Textfield studentName = cp5.addTextfield("studentName")
    .setPosition(10, height-50)
      .setSize(150, 30)
        .setColor(color(128))
          .setLabel("Student Name")
            .setGroup(g);
  studentName.captionLabel().setColor(color(0));
  Button add = cp5.addButton("addStudent")
    .setValue(0)
      .setSize(50, 30)
        .setPosition(170, height-50)
          .setLabel("Add")
            .setGroup(g);
  Button remove = cp5.addButton("removeStudent")
    .setValue(0)
      .setSize(50, 30)
        .setPosition(230, height-50)
          .setLabel("Remove")
            .setGroup(g);
  //Weights
  Textfield hwWeight = cp5.addTextfield("hwWeight")
    .setPosition(width/2+40, 10)
      .setSize(180, 30)
        .setColor(color(128))
          .setLabel("Homework Weight")
            .setGroup(g);
  hwWeight.captionLabel().setColor(color(0));
  Textfield classWorkWeight = cp5.addTextfield("classWorkWeight")
    .setPosition(width/2+40, 70)
      .setSize(180, 30)
        .setColor(color(128))
          .setLabel("Classwork Weight")
            .setGroup(g);
  classWorkWeight.captionLabel().setColor(color(0));
  Textfield quizWeight = cp5.addTextfield("quizWeight")
    .setPosition(width/2+40, 130)
      .setSize(180, 30)
        .setColor(color(128))
          .setLabel("Quiz Weight")
            .setGroup(g);
  quizWeight.captionLabel().setColor(color(0));
  Textfield testWeight = cp5.addTextfield("testWeight")
    .setPosition(width/2+40, 190)
      .setSize(180, 30)
        .setColor(color(128))
          .setLabel("Test Weight")
            .setGroup(g);
  testWeight.captionLabel().setColor(color(0));
  Textfield projectWeight = cp5.addTextfield("projectWeight")
    .setPosition(width/2+40, 250)
      .setSize(180, 30)
        .setColor(color(128))
          .setLabel("Project Weight")
            .setGroup(g);
  projectWeight.captionLabel().setColor(color(0));
  Textfield finalWeight = cp5.addTextfield("finalWeight")
    .setPosition(width/2+40, 310)
      .setSize(180, 30)
        .setColor(color(128))
          .setLabel("Final Exam Weight")
            .setGroup(g);
  finalWeight.captionLabel().setColor(color(0));
  Button ok = cp5.addButton("saveClass")
    .setValue(0)
      .setSize(50, 30)
        .setPosition(width-130, height-50)
          .setLabel("OK")
            .setGroup(g);
  Button cancel = cp5.addButton("cancelClass")
    .setValue(0)
      .setSize(50, 30)
        .setPosition(width-70, height-50)
          .setLabel("Cancel")
            .setGroup(g);
  return g;
}

