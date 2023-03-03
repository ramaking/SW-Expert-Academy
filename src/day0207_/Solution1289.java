package day0207_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1289 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			String line = br.readLine();
			
			char now = '1';
			int result = 0;
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == now) {
					result++;
					if(now == '1') {
						now = '0';
					} else {
						now = '1';
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
