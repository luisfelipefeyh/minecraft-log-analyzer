import java.io.BufferedReader;
import java.io.FileReader;

public class LogAnalyzer {
  public static void main(String[] args) throws Exception {
    for(String arg : args) {
      if(arg.equals("--print-all")) {
        try (BufferedReader reader = new BufferedReader(new FileReader("latest.log"))) {
          String line;
          while((line = reader.readLine()) != null) {
            System.out.println(line); 
          }
        }
      }
    }
  }
}
