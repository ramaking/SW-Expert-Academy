import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution3124 {

	static int V, E;
	static ArrayList<Edge>[] list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V + 1];
			
			for(int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				list[b].add(new Edge(a, c));
				list[a].add(new Edge(b, c));
			}
			
			System.out.println("#" + t + " " + prime(1));
		}

	}
	
	private static long prime(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		pq.add(new Edge(start, 0));
		int cnt = 0;
		long result = 0;
		while(!pq.isEmpty() && cnt < V) {
			Edge edge = pq.poll();
			
			if(visited[edge.to]) continue;
			visited[edge.to] = true;
			result += edge.weight;
			cnt++;
			for(Edge temp : list[edge.to]) {
				if(!visited[temp.to]) {
					pq.add(new Edge(temp.to, temp.weight));
				}
			}
		}
		
		return result;
	}

	static class Edge implements Comparable<Edge>{
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		int to, weight;

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}


}
