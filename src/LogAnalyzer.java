import java.io.BufferedReader;
import java.io.FileReader;

public class LogAnalyzer {
  public static void main(String[] args) throws Exception {
    String logfile = "latest.log";
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("--file")) {
        if (i + 1 < args.length) {
          logfile = args[i + 1];
          System.out.println(logfile);
          i++;
        }
      }
      if (args[i].equals("--print-all")) {
        try (BufferedReader reader = new BufferedReader(new FileReader(logfile))) {
          String line;
          while ((line = reader.readLine()) != null) {
            System.out.println(line); 
          }
        }
      }
    }
  }
}
