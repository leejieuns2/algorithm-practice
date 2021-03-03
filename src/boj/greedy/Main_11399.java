package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/* 11399. ATM
 * https://www.acmicpc.net/problem/11399
 * 시간복잡도 O(n)
 */

public class Main_11399 {

	public static int solution(int n, ArrayList<Integer> p) {
		int[] cnt = new int[n]; // 각 사람마다 소요되는 시간을 저장해놓는 배열
		int rslt = 0;
		
		Arrays.fill(cnt, 0); // 배열을 0으로 초기화
		Collections.sort(p); // 인출하는 데 시간이 적은 순서대로 정렬하기
		
		for(int i = 0; i < n; i ++) {
			if(i == 0) {
				cnt[i] = p.get(i);
				rslt += cnt[i];
			} else {
				cnt[i] = p.get(i) + cnt[i - 1];
				rslt += cnt[i];
			}
			System.out.println("cnt : " + rslt);
		}
		return rslt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine()); // 사람의 수
		st = new StringTokenizer(br.readLine(), " "); // NumberFormatException, IOException 처리

		ArrayList<Integer> p = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			p.add(Integer.parseInt(st.nextToken()));
		}
		System.out.println(solution(n, p));
	}
}
