package sweTraining.miscellaneous;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVTaskChecker
{
   public static void main(String[] args) throws Exception
   {
      String folderPath = "C:\\Users\\hkalantri\\Downloads\\VMIS_2";
      File folder = new File(folderPath);
      File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));

      List<String> issues = new ArrayList<>();

      if (files == null || files.length == 0)
      {
         System.out.println("No CSV files found in the folder: " + folderPath);
         return;
      }

      for (File file : files)
      {
         List<String> fileIssues = checkFile(file.getAbsolutePath());
         issues.addAll(fileIssues);
      }

      // Write to file and print to console
      if (issues.isEmpty())
      {
         System.out.println("No invalid DSCP/task_id combinations found in any file.");
      }
      else
      {
         System.out.println("INVALID combinations found:");
         for (String issue : issues)
         {
            System.out.println(issue);
         }
         // Save the file in your Downloads directory
         try (PrintWriter out = new PrintWriter("C:\\Users\\hkalantri\\Downloads\\invalid_combinations_report.txt"))
         {
            for (String issue : issues)
            {
               out.println(issue);
            }
         }
         System.out.println("Full report saved to C:\\Users\\hkalantri\\Downloads\\invalid_combinations_report.txt");
      }
   }

   private static List<String> checkFile(String filePath)
   {
      List<String> issues = new ArrayList<>();
      try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
      {
         String header = reader.readLine();
         if (header == null)
            return issues;
         String[] cols = header.split("\t");
         int nameIdx = -1, idIdx = -1;
         // Find the column indices
         for (int i = 0; i < cols.length; i++)
         {
            if (cols[i].trim().equals("!!!tasks.name"))
               nameIdx = i;
            if (cols[i].trim().equals("!!!tasks.streams.task_id"))
               idIdx = i;
         }
         if (nameIdx == -1 || idIdx == -1)
         {
            issues.add("Could not find required columns in " + filePath);
            return issues;
         }
         String line;
         int lineNum = 1;
         boolean foundIssue = false;
         while ((line = reader.readLine()) != null)
         {
            lineNum++;
            String[] fields = line.split("\t", -1);
            if (fields.length <= Math.max(nameIdx, idIdx))
               continue;
            String name = fields[nameIdx].trim();
            String taskId = fields[idIdx].trim();
            // Only consider DSCP0 or DSCP46 and task_id 69 or 70
            if (("DSCP0".equals(name) || "DSCP46".equals(name)) && ("69".equals(taskId) || "70".equals(taskId)))
            {
               boolean valid = ("DSCP46".equals(name) && "69".equals(taskId)) || ("DSCP0".equals(name) && "70".equals(taskId));
               if (!valid)
               {
                  issues.add("Invalid combination in " + filePath + " at line " + lineNum + ": tasks.name=" + name + ", tasks.streams.task_id=" + taskId);
                  foundIssue = true;
               }
            }
         }
         if (!foundIssue)
         {
            issues.add("No invalid combinations found in " + filePath + ".");
         }
      }
      catch (IOException e)
      {
         issues.add("Error processing file: " + filePath + ": " + e.getMessage());
      }
      return issues;
   }
}
