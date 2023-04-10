package m4.day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_2383_2 {

	static class Person implements Comparable<Person> {
		int r, c;
		int arriveTime;
		int downCnt;
		int status;

		Person(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public void init() {
			arriveTime = downCnt = 0;
			status = W;
		}

		@Override
		public int compareTo(Person o) {

			return Integer.compare(this.arriveTime, o.arriveTime);
		}
	}

	static ArrayList<Person> persons;
	static int[][] stairList;
	static final int M = 1, W = 2, D = 3, C = 4;
	static int N, ans;
	static int[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {

			N = Integer.parseInt(br.readLine());

			persons = new ArrayList<>();
			stairList = new int[2][];

			ans = Integer.MAX_VALUE;

			int stairIdx = 0;

			for (int r = 1; r <= N; ++r) {
				st = new StringTokenizer(br.readLine());
				for (int c = 1; c <= N; ++c) {
					int num = Integer.parseInt(st.nextToken());

					if (num == 0) {
						continue;
					} else if (num == 1) {
						persons.add(new Person(r, c));
					} else {
						stairList[stairIdx] = new int[] { r, c, num };
						stairIdx++;
					}
				}
			}

			selected = new int[persons.size()];

			divide(0);

			System.out.println("#" + t + " " + ans);
		}
	}

	private static void divide(int idx) {

		if (idx == persons.size()) {

			int result = go();

			ans = ans > result ? result : ans;
			return;
		}

		selected[idx] = 1;
		divide(idx + 1);

		selected[idx] = 0;
		divide(idx + 1);
	}

	private static int go() {
		ArrayList<Person>[] list = new ArrayList[] { new ArrayList<Person>(), new ArrayList<Person>() };

		for (int i = 0; i < persons.size(); i++) {
			Person p = persons.get(i);
			p.init();
			int no = selected[i];
			p.arriveTime = Math.abs(p.r - stairList[no][0]) + Math.abs(p.c - stairList[no][1]);
			list[no].add(p);
		}

		int timeA = 0, timeB = 0;
		if (list[0].size() > 0) {
			timeA = processDown(list[0], stairList[0][2]);
		}

		if (list[1].size() > 0) {
			timeA = processDown(list[1], stairList[1][2]);
		}

		return timeA > timeB ? timeA : timeB;

	}

	static int processDown(ArrayList<Person> list, int heigth) {
		Collections.sort(list);
		int time = list.get(0).arriveTime;
		int size = list.size();

		int ingCnt = 0, cCnt = 0;
		Person p = null;
		while (true) {
			for (int i = 0; i < size; i++) {
				p = list.get(i);

				if (p.status == C) {
					continue;
				} else if (p.arriveTime == time) {
					p.status = W;
				} else if (p.status == W && ingCnt < 3) {
					p.status = D;
					p.downCnt = 1;
					ingCnt++;

				} else if (p.status == D) {
					if (p.downCnt == heigth) {
						p.status = C;
						ingCnt--;
						cCnt++;
					} else {
						p.downCnt++;
					}
				}
			}
			if (cCnt == size) {
				break;
			}
			time++;
		}

		return time;

	}
}