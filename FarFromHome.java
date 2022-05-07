import java.util.*;
public class FarFromHome {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		int n = console.nextInt();
		int k = console.nextInt();
		
		int[] graph = new int[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = console.nextInt();
		
		int safe = n;
		for (int i = 1; i <= n; i++) {
			Queue<PathNode> bfs = new LinkedList<>();
			bfs.add(new PathNode(i,0));
			boolean[] visited = new boolean[n + 1];
			PathNode cur;
			while (!bfs.isEmpty()) {
				cur = bfs.poll();
				if (visited[cur.i])
					continue;
				if (cur.distance > k) {
					safe--;
					break;
				}
				visited[cur.i] = true;
				bfs.add(new PathNode(graph[cur.i],cur.distance+1));
			}
		}
		System.out.println(safe);
		console.close();
	}
}

class PathNode {
	int i, distance;
	public PathNode(int i, int distance) {
		this.i = i;
		this.distance = distance;
	}
}
