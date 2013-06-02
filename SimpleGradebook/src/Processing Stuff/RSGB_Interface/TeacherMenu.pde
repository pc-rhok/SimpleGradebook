String[] classNames;

Group teacherMenu() {
  // Set up the list of classes
  Group g = cp5.addGroup("teacherView");
  ListBox classes = cp5.addListBox("classList")
    .setPosition(0, 30)
      .setSize(width, height-50)
        .setItemHeight(30)
          .setBarHeight(30)
            .setColorBackground(color(255, 128))
              .setColorActive(color(0))
                .setColorForeground(#246076)
                  .setScrollbarWidth(20);
  classes.setGroup(g);

  classes.captionLabel().set("My Classes");
  classes.captionLabel().setColor(color(0));
  classes.captionLabel().style().marginTop = 3;
  classes.valueLabel().style().marginTop = 3;
  // Set up the button for adding classes
  Button addClass = cp5.addButton("addClass");
  addClass.setValue(0);
  addClass.setSize(200, 20);
  addClass.setPosition(width/2-100, height-50);
  addClass.setLabel("Add a New Class");
  addClass.setGroup(g);
  return g;
}

void loadClassNames() {
  classNames = new String[gb.courses.size()];
  for (int i = 0; i < gb.courses.size(); i++) {
    classNames[i] = gb.courses.get(i).getName();
  }
  ListBox classes = (ListBox)cp5.get("classList");
  classes.clear();
  for (int i = 0; i < classNames.length; i++) {
    ListBoxItem lbi = classes.addItem(classNames[i], i);
    lbi.setColorBackground(color(50));
  }
}
