//20240706刪除檔案
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
public class CreateFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("test.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
      
      if (myObj.delete()) { 
            System.out.println("Deleted the file: " + myObj.getName());
      } else {
         System.out.println("Failed to delete the file.");
        } 
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
  }
}

//產生檔案
/*
 * import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class CreateFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("filename.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
 */