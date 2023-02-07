package org.howard.edu.lsp.assignment2;

//Lauren Guthrie

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

public class Word_Counter {

	public static void main(String[] args) {
		try {
			FileReader input_file = new FileReader();
			Hashtable<String, Integer> Word_Occurances = Word_Occurances(input_file.readToString("main/java/resources/words.txt"));
			Word_Count_Output(Word_Occurances);
		}catch (FileNotFoundException e) {
			System.out.println("Unable to open resource");
		}
	}
	
	public static void Word_Count_Output(Hashtable<String, Integer> Word_Occurances) {
		Word_Occurances.forEach((key, value) -> {
			System.out.println(key + "  " + value);
		});
	}
	
	public static List<String> String_Manipulation(String word){
		List<String> formatted_strings = new ArrayList<>();
		String[] remove_ws = word.split("\\s+");
		for (String string: remove_ws) {
			try {
				@SuppressWarnings("unused")
				int num_check = Integer.parseInt(string);
			}
			catch(Exception e) {
				if(string.length() > 3) {
					formatted_strings.add(string);
				}
			}
		}
		
		return formatted_strings;
	}
	
	public static Hashtable<String, Integer> Word_Occurances(String word){
		//Counts the occurrence of each word in the file
		
		word = word.replace("\n", " ");
		List<String> formatted_strings = String_Manipulation(word);
		
		Hashtable<String, Integer> word_count = new Hashtable<String,Integer>();
		for(String string: formatted_strings){
			String lower_case_string = string.toLowerCase();
			if (word_count.containsKey(lower_case_string)){
				int word_total = word_count.get(lower_case_string);
				word_count.put(lower_case_string, word_total+1);
			}else {
				word_count.put(lower_case_string, 1);
			}
		}
		return word_count;
	}
}
