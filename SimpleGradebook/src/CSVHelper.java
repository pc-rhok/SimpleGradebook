import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVHelper {
  public String[] array = new String[34];

  public void run() {
    String csvFile = "config.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";

    try {

      br = new BufferedReader(new FileReader(csvFile));
      // position = 1 because we are getting the 2nd column
      int position = 1;
      int counter = 0;
      while ( (line = br.readLine ()) != null) {

        // use comma as separator
        String[] lineFromCSV = line.split(cvsSplitBy);
        array[counter] = lineFromCSV[position];
        counter++;
      }
    } 
    catch (FileNotFoundException e) {
      e.printStackTrace();
    } 
    catch (IOException e) {
      e.printStackTrace();
    } 
    finally {
      if (br != null) {
        try {
          br.close();
        } 
        catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    System.out.println("Done");
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }
}

