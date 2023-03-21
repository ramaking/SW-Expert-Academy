package day0303;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1249 {
	static int n;
	static int[][] map;
	static int[][] sum;
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		String line;
		for (int tc = 1; tc <= t; tc++) {

			n = Integer.parseInt(br.readLine());


			map = new int[n][n];
			sum = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				Arrays.fill(sum[i], Integer.MAX_VALUE);
			}

			for (int i = 0; i < n; i++) {
				line = br.readLine();
				for(int j = 0; j < n; j++) {
					map[i][j] = line.charAt(j)-'0';
				}
			}

			bfs(0, 0, 0);

			System.out.println("#" + tc + " " + sum[n-1][n-1]);
		}
	}

	private static void bfs(int si, int sj, int st) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {si, sj, st});
		int ci, cj, ni,nj;
		sum[0][0] = 0;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			ci = now[0];
			cj = now[1];
			
			for(int d= 0; d < 4; d++) {
				ni = ci + di[d];
				nj = cj + dj[d];
				
				if(ni < 0 || ni >= n || nj < 0 || nj >= n)
					continue;
				if(sum[ni][nj] > (now[2] + map[ni][nj])) {
					sum[ni][nj] = now[2] + map[ni][nj];
					queue.add(new int[] {ni, nj, now[2] + map[ni][nj]});
				}
			}
		}
	}

	private static void print() {
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				System.out.print(sum[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}
	

}
