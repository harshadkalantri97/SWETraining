package sweTraining.miscellaneous;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MoveFilesToSubFolders
{

   public static void main(String[] args)
   {
      // Base directory containing folders and files
      String baseDir = "C:\\data\\components\\interfaces\\01.43";

      // List of extensions to move
      String[] extensions = { ".iar", ".slar" };

      File baseDirectory = new File(baseDir);
      if (baseDirectory.exists() && baseDirectory.isDirectory())
      {
         for (File folder : baseDirectory.listFiles(File::isDirectory))
         {
            for (String extension : extensions)
            {
               moveFileToSubFolder(folder, extension);
            }
         }
      }
      else
      {
         System.out.println("Base directory does not exist or is not a directory.");
      }
   }

   private static void moveFileToSubFolder(File folder, String extension)
   {
      String fileName = folder.getName() + extension;
      File fileToMove = new File(folder.getParent(), fileName);

      if (fileToMove.exists())
      {
         File[] subFolders = folder.listFiles((dir, name) -> name.startsWith("03."));
         if (subFolders != null && subFolders.length > 0)
         {
            File subFolder = subFolders[0]; // Assume only one sub-folder starts with "03."

            Path sourcePath = fileToMove.toPath();
            Path targetPath = new File(subFolder, fileToMove.getName()).toPath();

            try
            {
               Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
               System.out.println("Moved " + fileName + " to " + subFolder.getPath());
            }
            catch (IOException e)
            {
               System.err.println("Error moving file " + fileName + ": " + e.getMessage());
            }
         }
         else
         {
            System.out.println("No sub-folder starting with '03.' found in " + folder.getPath());
         }
      }
      else
      {
         System.out.println(fileName + " does not exist in " + folder.getParent());
      }
   }
}
