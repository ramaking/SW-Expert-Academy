import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1238 {

	static int n,start;
	static ArrayList<Integer>[] list;
	static int max;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[101];
			
			for(int i = 1; i <= 100; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			int from , to;
			for(int i = 0; i < n/2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}
			
			max = 0;
			
			
			
			System.out.println("#" + t + " " + bfs(start));
		}

	}

	private static int bfs(int start) {
		int result = start;
		boolean[] visited = new boolean[101];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;
		int max = 0;
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			boolean isMore = false;
			for(int i = 0; i < size; i++) {
				
				int now = queue.poll();
				max = Math.max(max, now);
				for(int j : list[now]) {
					if(!visited[j]) {
						isMore = true;
						visited[j] = true;
						queue.add(j);
						
					}
				}
				
			}
			if(isMore) {
				
				max = 0;
				isMore = false;
			} else {
				
			}
			result = max;
			
			
		}
		return result;
		
	}

}
