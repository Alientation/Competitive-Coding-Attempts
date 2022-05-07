import java.util.HashMap;
import java.util.Scanner;

public class MorseCode {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int testcase = console.nextInt();
		console.nextLine();
		for (; testcase > 0; testcase--) {
			HashMap<String,String> letterToMorse = new HashMap<>();
			letterToMorse.put(" ", " ");
			HashMap<String,String> morseToLetter = new HashMap<>();
			morseToLetter.put(""," ");
			for (int i = 0; i < 26; i++) {
				String input = console.nextLine();
				letterToMorse.put(input.charAt(0) + "", input.substring(2));
				morseToLetter.put(input.substring(2),input.charAt(0) + "");
			}
			String sentence = console.nextLine();
			boolean bool = false;
			for (char c : sentence.toCharArray()) {
				if (bool) {
					System.out.print("   ");
				} else
					bool = true;
				
				System.out.print(letterToMorse.get(("" + c).toUpperCase()));
			}
			System.out.println();
			
			String crypt = console.nextLine();
			for (String c : crypt.split("   ")) {
				c = c.trim();
				System.out.print(morseToLetter.get(("" + c)));
			}
			System.out.println();
		}
		console.close();
	}
}
