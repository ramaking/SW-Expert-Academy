package day0207_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5215 {
	static int N, L;
	static int[][] numbers;
	static int[][] card;
	static boolean[] visited;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			numbers = new int[N][2];
			card = new int[N][2];
			visited = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				//맛
				numbers[i][0] = Integer.parseInt(st.nextToken());
				//칼로리
				numbers[i][1] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);

			System.out.println("#" + tc + " " + max);
		}
	}
	
	static void comb(int cnt, int start) {
		
		if(cnt == N) {
			int ta = 0;
			int cal = 0;
			
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					ta += numbers[i][0];
					cal += numbers[i][1];
				}
			}
			if(cal <= L) {
				max = Math.max(ta, max);
			}
//			System.out.println(ta);

//			System.out.println(cal);
//			System.out.println("sdf");
			return;
		}
		
		for(int i = start; i < N; i++) {
			visited[start] = true;		
			comb(cnt+1, i+1);
			visited[start] = false;
			comb(cnt+1, i+1);
			
		}
	}


}
