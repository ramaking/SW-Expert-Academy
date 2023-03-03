package day0207_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution7465 {
	static int n, m;
	static int[] relation;
	static Set<Integer> set = new HashSet<>();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			relation = new int[n+1];
			for(int i = 1; i <= n; i++) {
				relation[i] = i;
			}
			
			for(int k = 0; k < m; k++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			
			for(int i = 1; i <= n; i++) {
				set.add(find(i));
			}

			System.out.println("#" + tc + " " + set.size());
			set.clear();
		}
	}


	private static void union(int a, int b) {
		// TODO Auto-generated method stub
		int p1 = find(a);
		int p2 = find(b);
		
		relation[p2] = p1;
	}
	
	private static int find(int i) {
		if(relation[i] == i) {
			return i;
		}else {
			return relation[i] =find(relation[i]);
		}
	}
	
	

}
