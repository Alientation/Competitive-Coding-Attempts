import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class PastIsPrologue {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		for (int testcase = console.nextInt(); testcase > 0; testcase--) {
			int N = console.nextInt();
			console.nextLine();
			HashMap<String,int[]> hm = new HashMap<>();
			HashSet<String> uniqueEvents = new HashSet<>();
			ArrayList<String> eventnames = new ArrayList<>();
			HashSet<String> pastIDS = new HashSet<>();
			HashSet<String> pastPart = new HashSet<>();
			for (int i = 0;i < N; i++) {
				String[] inputs = console.nextLine().split(",");
				if (pastPart.contains(inputs[1] + "." + inputs[2] + "." + inputs[3]))
					continue;
				pastPart.add(inputs[1] + "." + inputs[2] + "." + inputs[3]);
				if (pastIDS.contains(inputs[0])) {
					continue;
				}
				pastIDS.add(inputs[0]);
				if (!uniqueEvents.contains(inputs[3])) {
					uniqueEvents.add(inputs[3]);
					eventnames.add(inputs[3]);
					if (inputs[4].equals("true")) {
						if (inputs[2].equals("Day"))
							hm.put(inputs[3], new int[] {1,0});
						else
							hm.put(inputs[3], new int[] {0,1});
					} else {
						hm.put(inputs[3], new int[] {0,0});
					}
				} else {
					if (inputs[4].equals("true")) {
						int[] in = hm.get(inputs[3]);
						if (inputs[2].equals("Day"))
							in[0]++;
						else
							in[1]++;
						hm.put(inputs[3], in);
					}
				}
			}
			Collections.sort(eventnames);
			for (int i = 0; i < eventnames.size(); i++) {
				System.out.println(eventnames.get(i) + "," + hm.get(eventnames.get(i))[0] + "," + hm.get(eventnames.get(i))[1]);
			}
		}
		console.close();
	}
}
