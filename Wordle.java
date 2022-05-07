import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class Wordle {
	public static void main(String[] args) throws IOException{
		Scanner console = new Scanner(new File("data.txt"));
		int n = console.nextInt();
		console.nextLine();
		for (int i = 0; i < n; i++) {
			out.println("Game #" + (i+1) + ":");
			String answer = console.nextLine();
			String nextGuess = console.nextLine();
			int guesses = 0;
			int wonGuesses = 0;
			boolean win = false;
			while (guesses < 6) {
				char[] output = new char[5];
				if (win) {
					out.println("WWWWW");
					guesses++;
					if (guesses < 6)
						nextGuess = console.nextLine();
					continue;
				}
				char[] chars = new char[answer.length()];
				for (int j = 0; j < answer.length(); j++)
					chars[j] = answer.charAt(j);
				for (int j = 0; j < answer.length(); j++) {
					if (nextGuess.charAt(j) == answer.charAt(j)) {
						output[j] = 'G';
						chars[j] = '0';
					} 
				}
				for (int j = 0; j < answer.length(); j++) {
					if (output[j] == 'G')
						continue;
					
					if (!contains(chars,nextGuess.charAt(j))) {
						output[j] = 'X';
					} else {
						for (int jj = 0; jj < chars.length; jj++) {
							if (nextGuess.charAt(j) == chars[jj]) {
								output[j] = 'Y';
								chars[jj] = '0';
								break;
							}
						}
					}
				}
				for (int j = 0; j < output.length; j++) {
					out.print(output[j]);
				}
				out.println();
				guesses++;
				if (nextGuess.equals(answer)) {
					win = true;
					wonGuesses = guesses;
				}
				if (guesses < 6) {
					nextGuess = console.nextLine();
				}
			}
			if (win) {
				out.print(answer + " was correctly guessed in " + wonGuesses + " guesses. ");
				switch(wonGuesses) {
					case 1: out.println("Wow! Either you got incredibly lucky or you are cheating!");
						break;
					case 2: out.println("Impressive! That didn't take you very long.");
						break;
					case 3: out.println("Nice! Not bad. Not bad at all.");
						break;
					case 4: out.println("Pretty decent.");
						break;
					case 5: out.println("Cutting it a little close there, but we like to see it.");
						break;
					case 6: out.println("Phew! That was a close one!");
						break;
				}
			} else {
				out.println(answer + " was not correctly guessed. Better luck next time.");
			}
			if (n > 1) {
				out.println();
			}
		}
	}
	public static boolean contains(char[] arr, char c) {
		for (char cc : arr)
			if (cc == c)
				return true;
		return false;
	}
}