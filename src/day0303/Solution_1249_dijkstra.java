package day0303;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1249_dijkstra {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		String line;
		for (int tc = 1; tc <= t; tc++) {

			n = Integer.parseInt(br.readLine());


			map = new int[n][n];
			visited = new boolean[n][n];
			

			for (int i = 0; i < n; i++) {
				line = br.readLine();
				for(int j = 0; j < n; j++) {
					map[i][j] = line.charAt(j)-'0';
				}
			}


			System.out.println("#" + tc + " " + dijkstra(0, 0, 0));
		}
	}

	private static int dijkstra(int si, int sj, int st) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point (si, sj, st));
		int ci, cj, ni,nj;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			ci = now.i;
			cj = now.j;
			if(visited[ci][cj]) continue;
			
			visited[ci][cj] = true;
			if(ci == n-1 && cj == n-1) {
				
				return now.dis;
			}
			
			for(int d= 0; d < 4; d++) {
				ni = ci + di[d];
				nj = cj + dj[d];
				
				if(ni < 0 || ni >= n || nj < 0 || nj >= n || visited[ni][nj])
					continue;
				queue.add(new Point(ni, nj, now.dis + map[ni][nj]));
				
			}
		}
		return -1;
	}
	
	static class Point implements Comparable<Point>{
		public Point(int i, int j, int dis) {
			super();
			this.i = i;
			this.j = j;
			this.dis = dis;
		}

		int i, j, dis;

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.dis - o.dis;
		}
		
	}
	

}
