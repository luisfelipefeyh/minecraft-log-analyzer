import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogAnalyzer {
  private static final Pattern TIME_PATTERN = Pattern.compile("\\b(\\d{2}:\\d{2}:\\d{2})");
  public static void main(String[] args) throws Exception {
    String logfile = "latest.log";
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("--file")) {
        if (i + 1 < args.length) {
          logfile = args[i + 1];
          i++;
        }
      } else if (args[i].equals("--print-all")) {
        try (BufferedReader reader = new BufferedReader(new FileReader(logfile))) {
          String line;
          while ((line = reader.readLine()) != null) {
            System.out.println(line); 
          }
        }
      } else if (args[i].equals("--advancements")) {
        try (BufferedReader reader = new BufferedReader(new FileReader(logfile))) {
          String line;
          int counter = 0;
          while ((line = reader.readLine()) != null) {
            if (line.contains("has made the advancement")) {
              counter++;
            }
          }
          System.out.println("There has been a total of " + counter + " advancements made!");
        }
      } else if (args[i].equals("--messages-number")) {
        if (i + 2 < args.length && args[i + 1].equals("--since")) {
          int counter = 0;
          LocalTime threshold = LocalTime.parse(args[i + 2]);
          i += 2;
          try (BufferedReader reader = new BufferedReader(new FileReader(logfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
              Matcher m = TIME_PATTERN.matcher(line);
              if (m.find()) {
                String time = m.group(1);
                LocalTime msgTime = LocalTime.parse(time);
                if (!msgTime.isBefore(threshold) && line.contains("MinecraftServer/]: <")) {
                  String msg = line.substring(line.indexOf("<"));
                  counter++;
                  System.out.println(msg);
                }
              }
            }
            System.out.println(counter + " messages were sent since " + threshold);
          }
        }
      }
    }
  }
}
