package m4.day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1263 {
	
	static int[][] D;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int t = 1; t <= TC; t++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			D = new int[n+1][n+1];
			
			for(int i = 1; i <= n; i++) {
				for(int j = 1 ; j <= n; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp == 0 && i != j){
						D[i][j] = 1000000001;
					} else {
						D[i][j] = temp;
					}
				}
			}
			
			for(int k = 1; k <= n; k++) {
				for(int i = 1; i <= n; i++) {
					if(k == i) continue;
					for(int j = 1; j <= n; j++) {
						if(i == j) continue;
						if(j == k) continue;
						D[i][j] = Math.min(D[i][k] + D[k][j], D[i][j]);
						
					}
				}
			}
			
			for(int i = 0; i < n+1; i++) {
//				System.out.println(Arrays.toString(D[i]));
			}
			
			int min = Integer.MAX_VALUE;
			
			for(int i = 1; i <= n; i++) {
				int tempSum = 0;
				for(int j = 1; j <= n; j++) {
					
					tempSum+= D[i][j];
					
				}
				if(min > tempSum) {
					min = tempSum;
				}
			}
			
			
			
			sb.append("#"+t+" " + min).append("\n");
//			System.out.println();
		}
		System.out.println(sb.toString());
	}

}
