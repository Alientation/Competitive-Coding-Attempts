import java.util.*;
public class SplitTheVote {
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		if (n > 2) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = console.nextInt();
			for (int i = 0; i < n-1; i++) {
				for (int j = i + 1; j < n; j++) {
					int[] newArr = new int[n-2];
					int iii = 0;
					for (int ii = 0; ii < n; ii++)
						if (ii != i && ii != j)
							newArr[iii++] = arr[ii];
					min = Math.min(min, minDif(newArr));
				}
			}
		} else
			min = 0;
		System.out.println(min);
		console.close();
	}

	static int minDif(int newArr[]) {
		int sum = 0;
		for (int i = 0; i < newArr.length; i++)
			sum += newArr[i];
		
		boolean dp[][] = new boolean[newArr.length + 1][sum + 1];
		
		for (int i = 0; i <= newArr.length; i++)
			dp[i][0] = true;
		for (int i = 1; i <= sum; i++)
			dp[0][i] = false;
		
		for (int i = 1; i <= newArr.length; i++) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];
				if (newArr[i - 1] <= j)
					dp[i][j] |= dp[i - 1][j - newArr[i - 1]];
			}
		}
		int diff = Integer.MAX_VALUE;
		
		for (int j = sum / 2; j >= 0; j--) {
			if (dp[newArr.length][j] == true) {
				diff = sum - 2 * j;
				break;
			}
		}
		return diff;
	}
}
