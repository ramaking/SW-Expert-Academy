import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//1. 가장 많은  프로세서를 연결하라
//2. 연결이 가능할 경우 가장 전선을 조금만 사용하라
//3. 불가능 할 경우 연결할 프로레서의 수를 줄여라
public class Solution1767 {

//	static boolean[] used;
	static int n;
	static int min;
	static int[][] arr;
	static int[][] temp;
	static boolean[][] visited;
	static ArrayList<int[]> process = new ArrayList<>();
	static boolean isEnd;
	static boolean[] used;
	static int listSize;
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};
	static int tempSum;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= tc; t++) {

			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int temp = Integer.parseInt(st.nextToken());
					arr[i][j] = temp;

					// 프로세서의 위치를 저장
					if (temp == 1) {
						process.add(new int[] { i, j });
					}
				}
			}
			listSize = process.size();
			isEnd = false;
			min = Integer.MAX_VALUE;
			for(int i = listSize; i > 0; i--) {
				visited = new boolean[n][n];
				used = new boolean[listSize];
				temp = new int[n][n];
				if(isEnd) {
					break;
				}
				comb(0,0,i);
			}
			
			//다음 테케를 위해 초기화
			process.clear();
			
			System.out.println("#" + t + " " + min);
		}

	}

	private static void comb(int cnt, int start, int m) {
		// TODO Auto-generated method stub
		
		
		if(cnt == m) {
			System.out.println(Arrays.toString(used));
			tempSum = 0;
			deepCopy();
			//전선 연결
			connectLine(0, m);
			
			return;
		}
		
		for(int i = start; i <  listSize; i++) {
			used[i] = true;
			comb(cnt+1,i+1, m);
			used[i] = false;
		}
		
		
		
	}

	private static void connectLine(int index, int m) {
		// TODO Auto-generated method stub
		if(index == m) {
			//사용한 전선 계산
			isEnd = true;
			
			culc();
			
			return;
		}
		int si = process.get(index)[0];
		int sj = process.get(index)[1];
		
		for(int d = 0; d < 4; d++) {
			int ci = si;
			int cj = sj;
			int ni, nj;
			//지정한 방향으로 쭉 나아가다가 실패하거나 목적지에 도달하면 종료 및 다음 인덱스로
			while(true) {
				ni = ci + di[d];
				nj = cj + dj[d];
				if(ni < 0 || ni >= n || nj < 0 || nj >= n) {
					connectLine(index+1, m);
					break;
				} else {
					System.out.println(ni + " : " + nj);
					if(temp[ni][nj] == 0) {
						temp[ni][nj] = 2;
						ci = ni;
						cj = nj;
					} else {
						ci = ni;
						cj = nj;
						//다시 돌아가면서 0으로 바꾸기
						while(true) {
							ni = ci + di[(d+2)%4];
							nj = cj + dj[(d+2)%4];
							if(ni == si && nj == sj) {
								break;
							}
							temp[ni][nj] = 0;
						}
						
						break;
					}
				}
				
				
			}
		}
		
	}

	
	private static void culc() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(temp[i][j] == 2) {
					tempSum++;
				}
			}
		}
		
		if(min > tempSum) {
			min = tempSum;
		}
	}

	private static void deepCopy() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				temp[i][j] = arr[i][j];
			}
		}
	}

}
