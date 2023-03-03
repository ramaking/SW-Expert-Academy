package day0207_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2112 {
	static int D, W, K;
	static boolean[][] arr;
	static boolean[][] temp;
	static boolean[] visited;
	static boolean isEnd;
	static boolean[] tempValue;
	static int[] tempArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());

			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			arr = new boolean[D][W];
			temp = new boolean[D][W];

			isEnd = false;

			K = Integer.parseInt(st.nextToken());

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					if (Integer.parseInt(st.nextToken()) == 1)
						arr[i][j] = true;
				}
			}

			int result = 0;
			for (int i = 0; i <= K; i++) {
				visited = new boolean[D];

				recu(i, 0, 0);
				if (isEnd) {
					result = i;
					break;
				}
			}


			System.out.println("#" + tc + " " + result);
		}
	}

	// maxCnt 뽑는조합
	// cnt : 뽑은 개수
	// index : 현재 보는 인덱스
	static void recu(int maxCnt, int cnt, int index) {
		if (isEnd) {
			return;
		}
		// 탈출 부분
		if (cnt == maxCnt) {

			tempArr = new int[maxCnt];
			int tempIdx = 0;

			// 어떤 레이어를 선택했는지 불러옴
			for (int i = 0; i < D; i++) {
				if (visited[i]) {
					tempArr[tempIdx++] = i;
				}
			}

			// temp 배열에 있는 index의 배열을 A와 B로 한번 씩 다 바꾸고 확인
			// temp 배열의 index 중 어느 것을 A로 칠할 건지 어느 것을 B로 칠할 건지 선택
			// 중복순열...?

			tempValue = new boolean[maxCnt];

			recu2(tempValue, 0, maxCnt);

			return;
		}

		if (index == D) {
			return;
		}

		// 재귀 부분
		visited[index] = true;
		recu(maxCnt, cnt + 1, index + 1);
		visited[index] = false;
		recu(maxCnt, cnt, index + 1);

	}

	static boolean totalIsSafe() {
		for (int i = 0; i < W; i++) {
			// 문제가 있다면 false 반환
			if (!lineIsSafe(i)) {
				return false;
			}
		}
		return true;
	}

	static boolean lineIsSafe(int index) {
		boolean tempValue = temp[0][index];
		int cnt = 1;
		for (int i = 1; i < D; i++) {
			if (temp[i][index] == tempValue) {
				cnt++;
			} else {
				tempValue = temp[i][index];
				cnt = 1;
			}
			if (cnt >= K) {
				return true;
			}
		}
		if (cnt < K) {
			return false;
		}

		return true;
	}

	// 중복 순열
	static void recu2(boolean[] tempValue, int cnt, int maxCnt) {
		if (isEnd) {
			return;
		}
		if (cnt == maxCnt) {
			for (int j = 0; j < D; j++) {
				temp[j] = arr[j].clone();
			}

			for (int i = 0; i < maxCnt; i++) {
				for (int j = 0; j < W; j++)
					temp[tempArr[i]][j] = tempValue[i];
			}

			if (totalIsSafe()) {
				isEnd = true;
			}
//			print();
			return;
		}

		for (int i = 0; i < 2; i++) {
			if (i == 0)
				tempValue[cnt] = false;
			else
				tempValue[cnt] = true;
			recu2(tempValue, cnt + 1, maxCnt);

		}
	}

	static void print() {
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				if (temp[i][j])
					System.out.print(1 + " ");
				if (!temp[i][j])
					System.out.print(0 + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");
	}

}
