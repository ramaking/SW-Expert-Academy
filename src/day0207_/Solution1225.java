package day0207_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1225 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
//			int[] arr = new int[8];
			
			Queue<Integer> que = new LinkedList<>();
			
			for(int i = 0; i < 8; i++) {
				que.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean flag = false;
			
			while(!flag) {
				
				for(int i = 1; i <= 5; i++) {
					int value = que.poll();
					value -= i;
					if(value <= 0) {
						value = 0;
						flag = true;
					}
					que.add(value);
					if(flag) {
						break;
					}
				}
			}
			
			Integer[] arr = que.toArray(new Integer[8]);
			
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < 8; i ++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
	
}
