import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class TheGoodShipInput {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		console.nextLine();
		for (int i = 0; i < n; i++) {
			int x = console.nextInt();
			int y = console.nextInt();
			console.nextLine();
			ArrayList<String> xList = new ArrayList<String>();
			ArrayList<String> yList = new ArrayList<>();
			HashMap<String,String> hm = new HashMap<>();
			for (int j = 0; j < x; j++) {
				xList.add(console.nextLine());
				hm.put(xList.get(j).toUpperCase(),xList.get(j));
				yList.add(xList.get(j).toUpperCase());
			}
			HashSet<String> con = new HashSet<>();
			Collections.sort(yList);
			for (int j = 0; j < y; j++) {
				con.add(console.nextLine());
			}
			for (int j = 0; j < yList.size(); j++) {
				if (!con.contains(hm.get(yList.get(j))))
					System.out.println(hm.get(yList.get(j)));
			}
		}
	}
}
