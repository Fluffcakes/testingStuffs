import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class nGram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner s = new Scanner(new File("To Kill A Mockingbird Text.txt"));
			HashMap<String, String> word = new HashMap<String, String>();
			String[] pair = new String[10000];
			String chosenWord = "the";
			int count = 0;
			int tick = 0;
			
			while(s.hasNextLine()) {
				String currLine = s.nextLine();
				String[] split = currLine.split(" ");
				for (int i = 0; i < split.length; i++) {
					if (tick == 1) {
						//pair[count] = split[i];
						word.put(chosenWord, split[i]);
						pair[count] = split[i];
						count++;
						tick--;
					}
					if (word.containsKey(chosenWord)) {
						tick++;
					}
					
				}
			}
			System.out.println("Key word: " + chosenWord);
			for (int i = 0; i < pair.length; i++) {
				if (pair[i] != null) {
					System.out.println(pair[i]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
