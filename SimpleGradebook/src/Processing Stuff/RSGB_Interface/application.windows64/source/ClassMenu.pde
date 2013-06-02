Group classMenu() {
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

