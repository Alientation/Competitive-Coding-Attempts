import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class Khadgar {
	public static void main(String[] args) throws IOException{
		Scanner console = new Scanner(new File("data.txt"));
		String x = console.next();
		String y = console.next();
		if (x .length() != y.length())
			out.println("no");
		else {
			int num1sX = 0;
			for (int i = 0; i < x.length(); i++)
				if (x.charAt(i) == '1')
					num1sX++;
			int num1sY = 0;
			for (int i = 0; i < y.length(); i++)
				if (y.charAt(i) == '1')
					num1sY++;
			if (num1sX != num1sY)
				out.println("no");
			else {
				boolean[] visited = new boolean[300];
				for (int i = 0; i < x.length() - 2; i++) {
					boolean found = false;
					if (x.substring(i, i + 3).equals("110"))
						for (int j = 0; j < y.length() - 2; j++)
							if (y.substring(j, j + 3).equals("011") && !visited[j]) {
								found = true;
								visited[j] = true;
								break;
							}
					if (x.substring(i, i + 3).equals("011"))
						for (int j = 0; j < y.length() - 2; j++)
							if (y.substring(j, j + 3).equals("110") && !visited[j]) {
								found = true;
								visited[j] = true;
								break;
							}
					if (x.substring(i, i + 3).equals("001"))
						for (int j = 0; j < y.length() - 2; j++)
							if (y.substring(j, j + 3).equals("100") && !visited[j]) {
								found = true;
								visited[j] = true;
								break;
							}
					if (x.substring(i, i + 3).equals("100"))
						for (int j = 0; j < y.length() - 2; j++)
							if (y.substring(j, j + 3).equals("001") && !visited[j]) {
								found = true;
								visited[j] = true;
								break;
							}
					if (!found) {
						out.println("no");
						break;
					}
				}
			}
		}
	}
}