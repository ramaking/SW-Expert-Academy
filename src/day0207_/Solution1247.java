package day0207_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1247 {
	static int n;
	static int companyI, companyJ, homeI, homeJ;
	static ArrayList<int[]> cosList;
	static int min;
	static boolean[] visited;
	static int[] card;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());

			cosList = new ArrayList<int[]>();

			visited = new boolean[n];

			card = new int[n];

			st = new StringTokenizer(br.readLine());

			companyI = Integer.parseInt(st.nextToken());
			companyJ = Integer.parseInt(st.nextToken());

			min = Integer.MAX_VALUE;
			
			homeI = Integer.parseInt(st.nextToken());
			homeJ = Integer.parseInt(st.nextToken());

			int cosI, cosJ;
			for (int i = 0; i < n; i++) {

				cosI = Integer.parseInt(st.nextToken());
				cosJ = Integer.parseInt(st.nextToken());
				cosList.add(new int[] { cosI, cosJ });

			}

			

			permu(0);

			System.out.println("#" + tc + " " + min);
		}
	}

	static void permu(int cnt) {

		if (cnt == n) {
			// 계산

			culc();
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				card[cnt] = i;
				permu(cnt + 1);
				visited[i] = false;
			}
		}
	}

	static void culc() {
		int sum = 0;
		// 회사에서 고객까지
		int pastI = companyI;
		int pastJ = companyJ;
		int currenI = 0, currenJ = 0;
		for (int i = 0; i < n; i++) {
			

			currenI = cosList.get(card[i])[0];
			currenJ = cosList.get(card[i])[1];
			sum += Math.abs(pastI - currenI) + Math.abs(pastJ - currenJ);
			if(sum >= min) {
				break;
			}
			pastI = currenI;
			pastJ = currenJ;
//			
		}

		sum += Math.abs(homeI - pastI) + Math.abs(homeJ - pastJ);

		if (min > sum) {
			min = sum;
		}

	}

}
