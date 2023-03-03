package day0207_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1208 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			
			int dumpNum = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			while(true) {
				if(dumpNum == 0) {
					break;
				}
				
				//맨 뒤에서 한 빼고 맨 앞에를 하나를 더함
				arr[99] -= 1;
				arr[0] += 1;
				dumpNum -= 1;
				
				Arrays.sort(arr);	
				
			}
			
			int result = arr[99] - arr[0];
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
