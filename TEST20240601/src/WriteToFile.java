//20240706建立檔案

import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
//import java.nio.file.Path;
import java.util.Scanner;

public class WriteToFile {
  public static void main(String[] args) {
    try {
      File f = new File("test.txt");
      f.createNewFile();//建立檔案
      FileWriter myWriter = new FileWriter("test.txt",true);//建立寫人器,true
      myWriter.write("Files in Java might be tricky, but it is fun enough!\n");//"\n":換行
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
      //Scanner s = new Scanner(new File("test.txt"));
      Scanner s = new Scanner(f);
      //Scanner s = new Scanner(new Path.getName("C:\\Users\\ping\\Documents\\Java\\test.txt"));//可以用path
      //建立讀取器並讀取一行(不用Reader是因為不要逐字讀取)
      
      String words = s.nextLine();
      System.out.println(words);
      s.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}