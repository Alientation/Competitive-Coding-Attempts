import java.util.*;
public class Whooosh {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int type = console.nextInt();
		switch(type) {
		case 0:
			System.out.println("mini whoosh");
			break;
		default:
			System.out.print("WHO");
			for (int i = 0; i < type; i++)
				System.out.print("O");
			System.out.println("SH!");
		}
		console.close();
	}
}
