package sweTraining.miscellaneous;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateFoldersAndZip
{

   public static void main(String[] args) throws IOException
   {
      String excelFilePath = "C:\\Users\\hkalantri\\Downloads\\Book1.xlsx"; // Adjust this path as needed
      String tempDir = "C:\\Users\\hkalantri\\Downloads\\temp_folders"; // Adjust this path as needed
      String zipFilePath = "C:\\Users\\hkalantri\\Downloads\\folders.zip"; // Adjust this path as needed

      // Create temporary directory
      Files.createDirectories(Paths.get(tempDir));

      // Read Excel file
      try (FileInputStream fis = new FileInputStream(new File(excelFilePath)); Workbook workbook = new XSSFWorkbook(fis))
      {

         Sheet sheet = workbook.getSheetAt(0);
         for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++)
         {
            Row row = sheet.getRow(rowIndex);
            String buildVersion = row.getCell(0).getStringCellValue();
            String iarName = row.getCell(1).getStringCellValue();

            // Create folder structure
            Path folderPath = Paths.get(tempDir, iarName, buildVersion);
            Files.createDirectories(folderPath);

            // Add dummy file
            Path dummyFilePath = folderPath.resolve("dummy.txt");
            Files.write(dummyFilePath, "This is a dummy file.".getBytes());
         }
      }

      // Create zip file
      try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath)))
      {
         Path sourceDirPath = Paths.get(tempDir);
         Files.walk(sourceDirPath).forEach(path -> {
            try
            {
               if (Files.isRegularFile(path))
               {
                  ZipEntry zipEntry = new ZipEntry(sourceDirPath.relativize(path).toString());
                  zos.putNextEntry(zipEntry);
                  Files.copy(path, zos);
                  zos.closeEntry();
               }
            }
            catch (IOException e)
            {
               e.printStackTrace();
            }
         });
      }

      // Clean up temporary directory
      Files.walk(Paths.get(tempDir)).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);

      System.out.println("Done!");
   }
}
