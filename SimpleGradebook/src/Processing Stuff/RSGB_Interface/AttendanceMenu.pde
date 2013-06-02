Group attendanceMenu() {
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

