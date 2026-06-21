package sweTraining.miscellaneous;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pathnames {
	public static String[] mySplitIntoTwo(String str)
	   {
	      String[] parts = str.split(",");

	      List<String> strList = new ArrayList<String>();

	      for(int x = 0; x < parts.length - 1; x = x+2)
	      {
	         String tmpStr = parts[x] + "," + parts[x+1];

	         strList.add(tmpStr);
	      }

	      return strList.toArray(new String[strList.size()]);
	   }

	public static void main(String[] args) {
		String strave = "Harshad, is, a, good, learner.";
		String[] newStr = mySplitIntoTwo(strave);
		System.out.println(Arrays.toString(newStr));
	}

}