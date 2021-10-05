import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
public class most_active_cookie {
	public static void main(String[] args) throws IOException{
		List<List<String>> records = new ArrayList<>();
		HashMap<String, Integer>  repeats = new HashMap<>(); 
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line;
		if(!args[1].equals("-d")) {
			System.out.println("No -d flag given,terminating program");
			System.exit(-1);
		}
		String date = args[2];
		
		ArrayList<String> rvs = new ArrayList<>();
		int max = 0;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        String[]dateTime = values[1].split("T");
		        if(date.equals(dateTime[0])) {
		        	repeats.put(values[0], repeats.getOrDefault(values[0], 0)+1);
		        	max = Math.max(repeats.get(values[0]), max);
		        }
		     }
		    for (String string : repeats.keySet()) {
				if(repeats.get(string)==max) {
					System.out.println(string);
				}
			}
		        

	}
}
