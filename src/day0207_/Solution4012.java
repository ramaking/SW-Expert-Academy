package day0207_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution4012 {
	
	static int[][] arr;
	static int n;
	static boolean[] visited;
//	static int[] numbers;
	static int[] tempA;
	static int[] tempB;
//	static int[] temp;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
//		temp = new int[2];
		
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			
//			numbers = new int[n/2];
			tempA = new int[n/2];
			
			tempB = new int[n/2];
			
			arr = new int[n][n];
			
			visited = new boolean[n];
			
//			int result = 0;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			System.out.println("qq");
			
			recu(0,0);
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	//N개 중N/2 개를 뽑는 조합
	static void recu(int cnt, int start) {
		if(cnt == n/2) {
//			System.out.println(cnt + " : " + start);
			int sumA = 0;
			int sumB = 0;
			
			
			int indexA = 0;
			int indexB = 0;
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					tempA[indexA++] = i;
					
				}
				if(!visited[i]) {
					tempB[indexB++] = i;
				}
			}
//			System.out.println("A : " +Arrays.toString(tempA));
//			System.out.println("B : " +Arrays.toString(tempB));
			
			for(int i = 0; i < n/2; i++) {
				for(int j = i+1; j < n/2; j++) {
					sumA += arr[tempA[i]][tempA[j]] + arr[tempA[j]][tempA[i]];
					sumB += arr[tempB[i]][tempB[j]] + arr[tempB[j]][tempB[i]];
				}
			}
			
			result = Math.min(result, Math.abs(sumA - sumB));
			
			
			return;
		}
		
		
		
		for(int i = start; i < n; i++) {
			visited[i] = true;
			recu(cnt+1, i+1);
			visited[i] = false;
		}
	}
	
	
	
	
}
