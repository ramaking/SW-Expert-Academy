import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656 {

	static int W, H, N;
	static int[][] map;
	static int[][] temp;
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};
	static int[] card;
	static boolean[][] visited;
	static int min;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			min = Integer.MAX_VALUE;
			
			map = new int[H][W];
			temp = new int[H][W];
			card = new int[N];
			visited = new boolean[H][W];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map [i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			permu(0);
			
			System.out.println("#" + t + " " + min);
		}

	}
	
	static void permu(int cnt) {
		
		if(min == 0) {
			return;
		}
		
		if(cnt == N) {
			
//			System.out.println(Arrays.toString(card));
			
			deepcopy();
			for(int i = 0; i < N; i++) {
				visited = new boolean[H][W];
				
				//던지기
				throwBall(card[i]);
				
				//내리기
				down();
				
			}
			
			culc();
			
			return;
		}
		
		for(int i = 0; i < W; i++) {
			card[cnt] = i;
			permu(cnt+1);
		}
		
	}
	
	private static void culc() {
		int sum = 0;
		for(int j = 0 ; j < W; j++) {
			for(int i = H-1; i >= 0; i--) {
				if(temp[i][j] != 0) {
					sum ++;
				}
			}
		}
		
		if(min > sum) {
			min = sum;
		}
		
	}

	private static void down() {
		Queue<Integer> queue = new ArrayDeque<>();
		for(int j = 0 ; j < W; j++) {
			for(int i = H-1; i >= 0; i--) {
				if(temp[i][j] != 0) {
					queue.add(temp[i][j]);
					temp[i][j] = 0;
				}
			}
			
			int index = H-1;
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				temp[index - i][j] = queue.poll();
			}
		}
	}

	private static void throwBall(int index) {
		int height = 0;
		//좌표에서 내려가면서 0이 아닌 값이 나올 때 까지
		while(true) {
			if(height == H) break;
			if(temp[height][index] != 0) {
				crack(height, index);
				break;
			} else {
				height++;
			}
		}
		
	}

	private static void crack(int height, int weight) {
		int size = temp[height][weight] - 1;
		temp[height][weight] = 0;
		visited[height][weight] = true;
		int ni, nj, ci, cj;
		for(int d = 0; d < 4; d++) {
			ci = height;
			cj = weight;
			for(int i = 0; i < size; i++) {
				ni = ci + di[d];
				nj = cj + dj[d];
				
				
				if(ni < 0 || ni >= H || nj < 0 || nj >= W) {
					break;
				}
				
				if(temp[ni][nj] != 0 && !visited[ni][nj]) {
					crack(ni, nj);
				}
				ci = ni;
				cj = nj;
				
			}
		}
	}

	static void deepcopy() {
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp[0].length; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}
	
	static void print() {
		for(int i = 0; i < H; i++) {
			for(int j = 0 ; j < W; j++) {
				System.out.print(temp[i][j] + " "); 
			}
			System.out.println();
		}
		System.out.println("------------------");
	}


}
