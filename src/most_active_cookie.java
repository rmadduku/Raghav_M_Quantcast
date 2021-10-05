import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
public class most_active_cookie {
	public static void main(String[] args) throws IOException{
		
		//hashmap storing cookie name, and its occurences
		HashMap<String, Integer>  repeats = new HashMap<>(); 
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line;
		int max = 0;
		
		//check if d flag is given or not
		if(!args[1].equals("-d")) {
			System.out.println("No -d flag given,terminating program");
			System.exit(-1);
		}
		String date = args[2];
		

		    while ((line = br.readLine()) != null) {
		    	
		    	//First split each line into cookie and time
		        String[] values = line.split(",");
		        
		        //Split time into day and hour
		        String[]dateTime = values[1].split("T");
		        
		        //since only date is important right now, use that in an if
		        if(date.equals(dateTime[0])) {
		        	
		        	//if the cookie has already been called, add to its counter
		        	repeats.put(values[0], repeats.getOrDefault(values[0], 0)+1);
		        	
		        	max = Math.max(repeats.get(values[0]), max);
		        }
		     }
		    // print out each cookie that got called the max times
		    for (String string : repeats.keySet()) {
				if(repeats.get(string)==max) {
					System.out.println(string);
				}
			}
		    br.close();
		        

	}
}
