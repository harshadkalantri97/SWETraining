package sweTraining.miscellaneous;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

public class ParserNo53207
{
   // String tagName = xpp.getName();
   // boolean attribute = tagName != null && "true".equals(tagName);
   // if (tagName.equalsIgnoreCase("value") || attribute == true)
   // {
   // for (int a = 0; a < tagName.length(); a++)
   // if (a % 2 == 0)
   // {
   // String[] Values = StringUtils.split(xpp.nextText(), ",");
   // List<String> tagList = new ArrayList<String>();
   // for (int i = 0, size = Values.length; i < size; i++)
   // {
   // String tmpValues = Values[i];
   // tagList.add(tmpValues);
   // }
   // }
   // else
   // {
   // tagName.toString();
   // }
   // }
   //
   public static void main(String[] args) throws IOException
   {
      String sFileName = "15minPerformanceLog_2022-02-17-08.00.00_PST_00.csv";
      String sContent = "ocH Egress";
      String testSub = "123456789";
      // System.out.println(StringUtils.substring(testSub, 0, 8));
      String fileName = "AP-BER-Repor-Zone3_2022_05_02_14_00.csv";
      int underscorePosition = StringUtils.ordinalIndexOf(fileName, "_", 1);
      int dotPosition = StringUtils.ordinalIndexOf(fileName, ".", 1);
      String date = StringUtils.substring(fileName, underscorePosition + 1, dotPosition);
      // System.out.println(date);
      String sContents = StringUtils.replace(sContent, " ", "_");
      String dataBlockId = StringUtils.substringBefore(sFileName, "_").concat("_" + sContents);
      // System.out.println(dataBlockId);
      String value = "1.04e-07";
      value = convertScietificNotation(value);
      // System.out.println(value);
      String sfileName = "UMEID_ITBBU_CP_20220505_1015-20220505_1030.csv";
      String dataBlock = StringUtils.substringAfter(sfileName, "-");
      // System.out.println(dataBlock);
      String s1 = "aabcccdee";
      String s2 = "Mycom_osi_Dev_Block";
      int dbIndex = StringUtils.ordinalIndexOf(s2, "_", 2);
      int indexx = StringUtils.ordinalIndexOf(s2, "_", 3);
      String dbId = StringUtils.substring(s2, dbIndex, indexx);
      System.out.println(dbId);
      // System.out.println("This is new DBID 74356 - " + dbId);
      // System.out.println(removeConsecutiveDuplicates(s));
      String subValue = "Devices/compute-254-101.domain.tld/hw/cpus/21";
      String[] splitValue = StringUtils.split(subValue, "/");
      String dataBlockValue = splitValue[0] + "_" + splitValue[3];
      // System.out.println(dataBlockValue);
      String FileName = "C:\\Work\\src\\depot\\sdk\\iarscanner\\01.00\\tmpIarUnzip\\ercs_afg_snmp_n1\\03.01.08\\config\\metadata\\ercs_afg_snmp_n1\\snmp_oid_ref.txt";
      String input = "Huawei Versatile Routing Platform Software \r\nVRP (R) software, Version 8.180 (CE7855EI V200R005C10SPC800) \r\nCopyright (C) 2012-2018 Huawei Technologies Co., Ltd. \r\nHUAWEI CE7855-32Q-EI \r\n";
      String output = StringUtils.replace(StringUtils.replace(input, "\r", ""), "\n", "");
      System.out.println("The output is: " + output);
      readUsingBufferedReader(FileName);
   }

   private static void readUsingBufferedReader(String fileName) throws IOException
   {
      File file = new File(fileName);
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line;
      while ((line = br.readLine()) != null)
      {
         // System.out.println(line);
         String[] data = ReadColPos(StringUtils.indexOfIgnoreCase(line, "add_param"), fileName, "\t");
         // System.out.println(Arrays.asList(data));
      }
      br.close();
      fr.close();
   }

   private static String[] ReadColPos(int j, String fileName, String seperator)
   {
      String data[];
      String currentLine;
      ArrayList<String> colData = new ArrayList<String>();

      try
      {
         FileReader fr = new FileReader(fileName);
         BufferedReader br = new BufferedReader(fr);
         while ((currentLine = br.readLine()) != null)
         {
            data = StringUtils.split(currentLine, seperator);
            colData.add(data[j]);
         }
      }
      catch (Exception e)
      {
         // System.out.println("No oid Value present");
      }
      return colData.toArray(new String[0]);
   }

   public static String removeConsecutiveDuplicates(String input)
   {
      if (input.contains("_"))
      {
         if (input.length() <= 4)
            return input;
         if (input.charAt(0) == input.charAt(1))
            return removeConsecutiveDuplicates(input.substring(1));
         else
         {
            return input.charAt(0) + removeConsecutiveDuplicates(input.substring(1));
         }
      }
      return input;
   }

   private static String convertScietificNotation(String value)
   {
      return new BigDecimal(value).toPlainString();
   }

}
