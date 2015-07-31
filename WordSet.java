import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
import java.util.Random;
import java.util.Scanner;
//import java.util.Set;

public class WordSet {
	
	private static Scanner file;
	private static ArrayList<String> words = new ArrayList<String>();
	//private static Map<String, Integer> occurences = new HashMap<String, Integer>();
	//private static Set<String> uniqueWords = new HashSet<String>(words);
	
	public static void openFile() throws IOException {
		
		try {
			file = new Scanner(new File("words.txt"));
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("IOException");
		}
	}
	
	public static String wordCount() throws IOException {
		
		Random r = new Random();
		
		while(file.hasNext()) {
			words.add(file.next());
			}
		
		String wordCount = words.get(r.nextInt(words.size()));
		return wordCount;
	}
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Enter a word to search: ");
		System.out.println("------------------------");
		openFile();
		
		Scanner scan = new Scanner(System.in);

		while(scan.hasNext()) {
			String input = scan.nextLine();
			
			Collections.frequency(words, input);
			wordCount();
			
			System.out.print("You have entered: " + " " + input + "\n" 
					+ "The word in the text file appears: "
					+ Collections.frequency(words, input));
			System.out.println(" times");
		}
		scan.close();
	}
}
