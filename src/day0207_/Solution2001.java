package day0207_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2001 {
	
	static int[][] arr;
	static int n,m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			
			int result = 0;
			
			for(int i = 0; i < n; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < n-m+1; i ++) {
				for(int j = 0; j < n-m+1; j++) {
					result = Math.max(result, getSum(i,j));
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static int getSum(int iIdx, int jIdx) {
		int sum = 0;
		
		for(int i = iIdx; i < iIdx+ m; i++) {
			for(int j = jIdx; j < jIdx+ m; j++) {
				sum += arr[i][j];
			}
		}
		
		return sum;
	}
}
