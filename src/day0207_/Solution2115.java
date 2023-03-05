package day0207_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2115 {
	static int N, M, C;
	static int[][] map;
	static int[][] sum;
	static boolean[] card;
	static int tempMax;
	static int totalMax = 0;
	static int[][] honey = new int[2][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			card = new boolean[M];
			sum = new int[N][N - M + 1];
			totalMax = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// sum 배열 채우기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					tempMax = 0;
					subSet(i, j, 0);
					sum[i][j] = tempMax;
				}
			}
			

			comb(0, 0);

			System.out.println("#" + tc + " " + totalMax);
		}
	}

	private static void comb(int cnt, int index) {
		if(cnt == 2) {
			
			
			
			int tsum = 0;
			if(honey[0][0] == honey[1][0]) {
				if(Math.abs(honey[1][1] - honey[0][1]) < M) {
					return;
				} 
			}
			
//			System.out.println(honey[0][0] + " : " + honey[0][1]);
//			System.out.println(honey[1][0] + " : " + honey[1][1]);
			
			tsum += sum[honey[0][0]][honey[0][1]];
			tsum += sum[honey[1][0]][honey[1][1]];
			
			if(totalMax < tsum) {
				totalMax = tsum;
			}
			
			return;
		}
		
		
		for(int idx = index; idx < N * (N-M+1); idx++) {
			
			int i = idx/(N-M+1);
			int j = idx%(N-M+1);
			
			honey[cnt] = new int[] {i, j};
			comb(cnt + 1, idx+1);
		}
		
		
	}

	private static void subSet(int si, int sj, int cnt) {

		if (cnt == M) {
			int sum = 0;
			int tsum = 0;
			for (int j = 0; j < M; j++) {
				if (card[j]) {
					sum += map[si][sj + j];
					tsum += Math.pow(map[si][sj + j], 2);
				}
			}

			if (sum <= C && tempMax < tsum) {
				tempMax = tsum;
			}
			return;
		}

		card[cnt] = true;
		subSet(si, sj, cnt + 1);
		card[cnt] = false;
		subSet(si, sj, cnt + 1);

	}

}
