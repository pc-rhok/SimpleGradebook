import java.util.HashMap;

String[] studentNames = {
  "alice", "bob", "carol", "dave", "emma", "fred", "gina"
};
HashMap<String, Boolean> attendance = new HashMap<String, Boolean>();

Group attendanceList() {
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
  return g;
}
