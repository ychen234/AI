
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Read {
	
	public static int[] read(String filename) throws IOException {
		File file = new File(filename); 
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String temp;
		String strings="";

		while ((temp=reader.readLine()) != null) {
			if(temp.equals("")) {
				break;
			}
			if (temp.charAt(0)=='c'||temp.charAt(0)=='p') {
				continue;
			}
			strings = strings + " " + temp + " ";
		} 
		
		//replace all the double space with one space
		strings = strings.replaceAll("\\s+", " ");
		// remove the space before the start of numbers
		strings = strings.substring(1); 
		for (int i = 1; i<strings.length();i++) {
			// deal with -
			if(strings.charAt(i) == '-') {
				if(strings.charAt(i-1)!= ' ') {
					String t1 = strings.substring(0, i);
					String t2 = strings.substring(i);
					t2 = " " + t2;
					strings = t1 + t2;
				}
			}
		}
		
		//convert string array to int array
		String [] temp_array = strings.split(" ");
		int[] clauses = new int[temp_array.length];
		
		for (int i = 0; i < temp_array.length; i++) {
			clauses[i] = Integer.valueOf(temp_array[i]);
		}
			
		reader.close();
		return clauses;
	}
	

}
