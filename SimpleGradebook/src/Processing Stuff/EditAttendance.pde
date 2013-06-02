import java.util.Date;

Date[] classDates = {
  new Date(2013, 11, 2), new Date(2013, 11, 3), new Date(2013, 11, 4), new Date(2013, 11, 5), new Date(2013, 11, 6)
};

Group editAttendance() {
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
                .setColorForeground(#246076)
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

