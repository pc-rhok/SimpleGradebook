Group studentList() {
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
                .setColorForeground(#246076)
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


