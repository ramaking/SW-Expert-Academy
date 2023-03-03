package day0207_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1873 {

	static int trainDir;
	static int h, w;
	static char[][] map;
	static int trainI, trainJ;
	static char[] command;
	static int[] idir = {-1,0,1,0};
	static int[] jdir = {0,1,0,-1};
	static char[] trainSh = {'^', '>', 'v', '<'};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());

			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			String line;
			for (int i = 0; i < h; i++) {
				line = br.readLine();

				for (int j = 0; j < w; j++) {

					char temp = line.charAt(j);
					map[i][j] = temp;
					
					if(temp == '^' || temp == '>' || temp == 'v' || temp == '<') {
						trainI = i;
						trainJ = j;
						switch (temp) {
						case '^':
							
							trainDir = 0;
							break;
						case '>':
							trainDir = 1;
							break;
						case 'v':
							trainDir = 2;
							break;
						case '<':
							trainDir = 3;
							break;
						}
						
					}

				}
			}
			
			int n = Integer.parseInt(br.readLine());
			command = new char[n];
			command = br.readLine().toCharArray();
			
			for(int i = 0; i < n; i++) {
				excute(command[i]);
//				print();
			}

			System.out.print("#" + tc + " ");
			print();
		}
	}
	
	private static void print() {
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	static void excute(char command) {
//		System.out.println(command);
		
		switch (command) {
		case 'U':
			trainDir = 0;
			move();
			
			break;
		case 'R':
			trainDir = 1;
			move();
			break;
		case 'D':
			trainDir = 2;
			move();
			break;
		case 'L':
			trainDir = 3;
			move();
			break;
		case 'S':
			shot();
			break;
		default:
			break;
		}
	}
	
	private static void shot() {
		int nI=trainI, nJ=trainJ;
		while(true) {
			
			nI += idir[trainDir];
			nJ += jdir[trainDir];
			if(nI < 0 || nI >= h || nJ < 0 || nJ >= w) {
				break;
			} else {
				
			}
				if(map[nI][nJ] == '.') {
					continue;
				}else if(map[nI][nJ] == '*'){
					map[nI][nJ] = '.';
					return;
				}else if(map[nI][nJ] == '#') {
					return;
				}
		}
	}

	static void move() {
		int nI = trainI+idir[trainDir];
		int nJ = trainJ+jdir[trainDir];
		
		if(nI >= 0 && nI < h && nJ >= 0 && nJ < w && map[nI][nJ] == '.') {
			map[trainI][trainJ] = '.';
			trainI = nI;
			trainJ = nJ;
		}
		map[trainI][trainJ] = trainSh[trainDir];
	}
}
