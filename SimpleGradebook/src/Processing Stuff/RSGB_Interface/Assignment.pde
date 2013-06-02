Group assignment() {
  // Set up the list of classes
  Group g = cp5.addGroup("assignment");
  // The back button
  Button back = cp5.addButton("backToAssignmentListFromAssignment")
    .setValue(0)
      .setSize(100, 50)
        .setPosition(0, 0)
          .setLabel("Back")
            .setGroup(g);
  // Assignment label
  Textfield assName = cp5.addTextfield("assignmentName")
    .setPosition(20, 100)
      .setSize(200, 40)
        .setFocus(true)
          .setColor(color(255, 0, 0))
            .setLabel("Assignment Name")
              .setGroup(g);
  assName.getCaptionLabel().setColor(color(0));
  return g;
}

