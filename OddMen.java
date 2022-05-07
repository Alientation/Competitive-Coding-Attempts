import java.util.*;
public class OddMen {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = console.nextInt();
		Arrays.sort(array);
		int ans = 0;
		for (int i = 0; i < n; i++)
			if ((i+1) % 2 != array[i] % 2)
				ans++;
			//if (getParity(i+1) != getParity(array[i]))
				//ans++;
		System.out.println(ans);
		console.close();
	}
	
	public static boolean getParity(int n) {
		boolean parity = false;
		while (n != 0) {
			parity = !parity;
			n = n & (n-1);
		}
		return parity;
	}
}
