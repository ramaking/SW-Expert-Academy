package m4.day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2382 {
	
	static Miseng[][] map;
	static Miseng[][] temp;
	static int[][] sum;
	static int n, m, k;
	static int[] di = {0, -1, 1, 0, 0};
	static int[] dj = {0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int t = 1; t <= TC; t++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new Miseng[n][n];
			
			
			
			for(int i = 1; i <= k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				map[a][b] = new Miseng(num, dir);
			}
			
			for(int i = 0; i < m; i++) {
				temp = new Miseng[n][n];
				sum = new int[n][n];
//				System.out.println(i);
				move();
				
				combine();
//				print();
				
				
			}
			
			
			
			int result = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					result += sum[i][j];
				}
			}
			
			sb.append("#"+t+" " + result).append("\n");
//			System.out.println();
		}
		System.out.println(sb.toString());
	}
	
	
	
	private static void print() {
		for(int i = 0; i < n; i++) {
			for(int j = 0;  j < n; j++) {
				System.out.print(sum[i][j] + " ");
				 
			}
			System.out.println();
		}
		System.out.println("===================");
	}



	private static void combine() {
		for(int i = 0; i < n; i++) {
			for(int j = 0;  j < n; j++) {
				if(temp[i][j] != null) {
					temp[i][j].num = sum[i][j];
					map[i][j] = temp[i][j].clone();
				}
			}
		}
			
		
	}

	private static void move() {
		int ni, nj;
		for(int i = 0; i < n; i++) {
			for(int j = 0;  j < n; j++) {
				if(map[i][j] != null) {
//					System.out.println(i + " " + j);
					ni = i + di[map[i][j].dir];
					nj = j + dj[map[i][j].dir];
					if(ni == 0 || ni == n-1 || nj == 0 || nj == n-1) {
						map[i][j].num = map[i][j].num/2;
						if(ni == 0)
							map[i][j].dir = 2;
						if(ni == n-1 )
							map[i][j].dir = 1;
						if(nj == 0)
							map[i][j].dir = 4;
						if(nj == n-1 )
							map[i][j].dir = 3;
					}
					sum[ni][nj] += map[i][j].num;
					
					if(temp[ni][nj] != null) {
						if(temp[ni][nj].num < map[i][j].num ) {
							temp[ni][nj] = map[i][j].clone();
//							temp[ni][nj].dir = map[i][j].dir;
//							temp[ni][nj].num = map[i][j].num;
						}
					} else {
						temp[ni][nj] = map[i][j].clone();
					}
					
					map[i][j] = null;
				}
			}
		}
		
	}

	static class Miseng {
		int max;
		int num;
		int dir;
		public Miseng(int num, int dir) {
			super();
			this.num = num;
			this.dir = dir;
		}

		protected Miseng clone(){
			// TODO Auto-generated method stub
			return new Miseng(num, dir);
		}
	}

}
