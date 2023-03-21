package day0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1767 {

	static int[][] map;
	static int N;
	static ArrayList<int[]> list = new ArrayList<>();
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int listSize;
	static int[] indexList;
	static int[] dirList;
	static boolean isEnd;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= t; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			min = Integer.MAX_VALUE;
			isEnd = false;
			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					if (map[i][j] == 1 && isValid(i, j)) {
						list.add(new int[] { i, j });
					}
				}
			}

			listSize = list.size();

			for (int i = listSize; i >= 0; i--) {
				if(isEnd) {
					break;
				}
				indexList = new int[i];
				dirList = new int[i];
				comb(0, 0, i);
//				System.out.println(i);
			}
			
			System.out.println("#" + tc + " " + min);
			
			list.clear();
			
		}
	}

	private static void comb(int cnt, int start, int size) {
		// 활성화 프로세스 선택 종료
		if (cnt == size) {

//			System.out.println(Arrays.toString(indexList));

			draw(size, 0);

			return;
		}

		for (int i = start; i < listSize; i++) {
			indexList[cnt] = i;
			comb(cnt + 1, i + 1, size);
		}
	}

	private static void draw(int size, int index) {
		if (index == size) {
			// 끝까지 다 그림! 성공 최소값 갱신 하고 return
			isEnd = true;
			
			//전선의 개수 세기
			count();
			
			return;
		}

		int[] now = list.get(indexList[index]);
		int ci = now[0];
		int cj = now[1];
		int ni, nj;
		
		for (int d = 0; d < 4; d++) {
			
			boolean isValid = false;
			// 방향에 맞게 끝까지 그리기
			while(true) {
				ni = ci + di[d];
				nj = cj + dj[d];
				if(ni < 0 || ni >= N || nj < 0 || nj >= N) {
					isValid = true;
					break;
				}
				if(map[ni][nj] != 0) {
					break;
				}
				map[ni][nj] = 2;
				ci = ni;
				cj = nj;
			}
			
			// 성공하면 그림 남겨두고 다음 걸로 넘김
			if(isValid) {
				draw(size, index+1);
			}

			// 다시 지우고 방향 바꾸기
			while(true) {
				if(ci == now[0] && cj == now[1]) {
					break;
				}
				map[ci][cj] = 0;
				ci = ci + di[(d+2)%4];
				cj = cj + dj[(d+2)%4];
			}

		}
		
	}


	private static void count() {
		int sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 2) {
					sum++;
				}
			}
		}
		if(min > sum) {
			min = sum;
		}
	}

	private static boolean isValid(int i, int j) {
		int ni, nj;
		int sum = 0;
		for (int d = 0; d < 4; d++) {
			ni = i + di[d];
			nj = j + dj[d];
			if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
				return false;
			}
			if (map[ni][nj] == 1) {
				sum++;
			}
		}
		if (sum == 4)
			return false;
		else
			return true;
	}

}
