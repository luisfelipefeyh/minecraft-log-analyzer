import java.io.BufferedReader;
import java.io.FileReader;

public class LogAnalyzer {
  public static void main(String[] args) throws Exception {
    String logfile;
    for(int i = 0; i < args.length; i++) {
      if (i + 1 < args.length) {
        if (args[i].equals("--file")) {
          logfile = args[i + 1];
          System.out.println(logfile);
        }
      }

      if(args[i].equals("--print-all")) {
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
