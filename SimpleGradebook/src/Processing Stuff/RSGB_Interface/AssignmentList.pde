String[] assignmentNames = {
  "a1", "a2", "a3", "a4", "a5", "a6", "a7"
};

Group assignmentList() {
  // Set up the list of classes
  Group g = cp5.addGroup("assignmentView");
  // The back button
  Button back = cp5.addButton("backToClassFromAssignment")
    .setValue(0)
      .setSize(100, 50)
        .setPosition(0, 0)
          .setLabel("Back")
            .setGroup(g);
  // The list of assignments
  ListBox classes = cp5.addListBox("assignmentList")
    .setPosition(0, 100)
      .setSize(width, height-150)
        .setItemHeight(30)
          .setBarHeight(30)
            .setColorBackground(color(255, 128))
              .setColorActive(color(0))
                .setColorForeground(#246076)
                  .setScrollbarWidth(20);
  classes.setGroup(g);

  classes.captionLabel().set("Assignments");
  classes.captionLabel().setFont(font);
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
  addAssignment.captionLabel().setFont(font);
  return g;
}

