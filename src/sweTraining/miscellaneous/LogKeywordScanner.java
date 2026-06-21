package sweTraining.miscellaneous;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class LogKeywordScanner
{
   public static void main(String[] args) throws Exception
   {
      String folderPath = "C:\\Users\\hkalantri\\Downloads\\TRANS_LOG"; // Or your log directory
      String[] keywords = { "DSCP46", "DSCP0", "duplicate", "error", "fail" };

      File folder = new File(folderPath);
      File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".log") || name.matches(".*\\.\\d+"));

      if (files == null || files.length == 0)
      {
         System.out.println("No log files found in: " + folderPath);
         return;
      }

      try (PrintWriter out = new PrintWriter(folderPath + "\\log_analysis_report.txt"))
      {
         for (File file : files)
         {
            try (BufferedReader reader = new BufferedReader(new FileReader(file)))
            {
               String prev = "", line = "", next = reader.readLine();
               int lineNum = 0;
               while ((line = next) != null)
               {
                  next = reader.readLine();
                  lineNum++;
                  for (String kw : keywords)
                  {
                     if (line.toLowerCase().contains(kw.toLowerCase()))
                     {
                        // Print/write with context: previous, current, next line
                        StringBuilder ctx = new StringBuilder();
                        ctx.append("File: ").append(file.getName()).append(", Line: ").append(lineNum).append("\n");
                        if (!prev.isEmpty())
                           ctx.append("  Prev: ").append(prev).append("\n");
                        ctx.append("  Match: ").append(line).append("\n");
                        if (next != null)
                           ctx.append("  Next: ").append(next).append("\n");
                        ctx.append("--------------------\n");
                        System.out.print(ctx);
                        out.print(ctx);
                        break;
                     }
                  }
                  prev = line;
               }
            }
         }
         System.out.println("Done! All matches saved to: " + folderPath + "\\log_analysis_report.txt");
      }
   }
}
