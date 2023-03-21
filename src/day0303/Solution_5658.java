package day0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_5658 {

	static int N, K;
	static int[] num;
	static Set<Long> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String line;
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			num = new int[N];
			set = new HashSet<>();
			line = br.readLine();
			for(int i = 0; i < N; i++) {
				char temp = line.charAt(i);
				if(temp >= 65) {
					num[i] = temp-'A'+10;
				} else {
					num[i] = temp-'0';
				}
			}
			

			
			for (int i = 0; i < N / 4; i++) {
				
				for (int k = 0; k < 4; k++) {
					long sum = 0;
					for (int j = 0; j < N / 4; j++) {
						int index = ((N / 4 * k + i) + j) % N;
//						System.out.println(index);
						sum += num[index]*Math.pow(16, N/4-j-1);
					}
//					System.out.println(sum);
					set.add(sum);
				}
			}
			Long[] tempArr = set.toArray(new Long[set.size()]);
			
			Arrays.sort(tempArr, Collections.reverseOrder());
			System.out.println("#"+tc+" " + tempArr[K-1]);

		}
	}

}
