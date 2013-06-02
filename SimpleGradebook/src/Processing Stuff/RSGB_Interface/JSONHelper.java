import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.*;

public class JSONHelper {

  public void storeToJSON(Object obj) {
    Gson gson = new Gson();
    String json = gson.toJson(obj);

    try {
      FileWriter writer = new FileWriter("file.json");
      writer.write(json);
      writer.close();
    } 
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public GradeBook getFromJSON() {

    Gson gson = new Gson();

    GradeBook gradeBook = null;

    try {
      BufferedReader br = new BufferedReader(new FileReader("file.json"));
      gradeBook = gson.fromJson(br, GradeBook.class);
    } 
    catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return gradeBook;
  }
}

