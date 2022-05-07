import java.util.*;
public class Comporial {
	public static HashMap<String,Character> hm = new HashMap<>();
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		hm.put(".-", 'A');
		hm.put("-...",'B');
		hm.put("-.-.",'C');
		hm.put("-..",'D');
		hm.put(".",'E');
		hm.put("..-.",'F');
		hm.put("--.",'G');
		hm.put("....",'H');
		hm.put("..",'I');
		hm.put(".---",'J');
		hm.put("-.-",'K');
		hm.put(".-..",'L');
		hm.put("--",'M');
		hm.put("-.",'N');
		hm.put("---",'O');
		hm.put(".--.",'P');
		hm.put("--.-",'Q');
		hm.put(".-.",'R');
		hm.put("...",'S');
		hm.put("-",'T');
		hm.put("..-",'U');
		hm.put("...-",'V');
		hm.put(".--",'W');
		hm.put("-..-",'X');
		hm.put("-.--",'Y');
		hm.put("--..",'Z');
		
		int shift = romanToInt(console.nextLine().trim()) % 26;
		for (String s : console.nextLine().split(" ")) {
			System.out.print((char)((hm.get(s) - 65 - shift + 52) % 26 + 65));
		}
		console.close();
	}
	
	public static int romanToInt(String s) {
        int ret = 0;
        while (s.indexOf("M") == 0) {
            ret += 1000;
            s = s.substring(1);
        }
        while (s.indexOf("CM") == 0) {
            ret += 900;
            s = s.substring(2);
        }
        while (s.indexOf("D") == 0) {
            ret += 500;
            s = s.substring(1);
        }
        while (s.indexOf("CD") == 0) {
            ret += 400;
            s = s.substring(2);
        }
        while (s.indexOf("C") == 0) {
            ret += 100;
            s = s.substring(1);
        }
        while (s.indexOf("XC") == 0) {
            ret += 90;
            s = s.substring(2);
        }
        while (s.indexOf("L") == 0) {
            ret += 50;
            s = s.substring(1);
        }
        while (s.indexOf("XL") == 0) {
            ret += 40;
            s = s.substring(2);
        }
        while (s.indexOf("X") == 0) {
            ret += 10;
            s = s.substring(1);
        }
        while (s.indexOf("IX") == 0) {
            ret += 9;
            s = s.substring(2);
        }
        while (s.indexOf("V") == 0) {
            ret += 5;
            s = s.substring(1);
        }
        while (s.indexOf("IV") == 0) {
            ret += 4;
            s = s.substring(2);
        }
        while (s.indexOf("I") == 0) {
            ret += 1;
            s = s.substring(1);
        }
        return ret;
    }
}
