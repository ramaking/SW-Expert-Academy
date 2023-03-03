package day0207_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution1228 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			LinkedList<Integer> list = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "I");
			for(int i = 0; i < t; i++) {
				//단일 명령어
				StringTokenizer st1 = new StringTokenizer(st.nextToken());
				
				int index = Integer.parseInt(st1.nextToken());
				
				int codeNum = Integer.parseInt(st1.nextToken());
//				int[] tempArr = new int[codeNum];
				
				for(int j = 0; j< codeNum; j++) {
					int temp = Integer.parseInt(st1.nextToken());
					list.add(index++, temp);
				}
			}
			
			
			System.out.print("#" + tc + " " );
			for(int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
	
}
