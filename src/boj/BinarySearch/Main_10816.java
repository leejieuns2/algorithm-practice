package boj.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 10816. 숫자 카드 2
 * https://www.acmicpc.net/problem/10816
 * */

/* HashMap Ver. */
public class Main_10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		// 조건에 맞는 값 입력받기
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		// 몇개인지 count할 배열
		
		st = new StringTokenizer(br.readLine());
		int tmp = 0;
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(hashMap.containsKey(num)) {
				tmp = hashMap.get(num);
			} else {
				tmp = 0;
			}
			hashMap.put(num, ++tmp);
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(hashMap.containsKey(num)) {
				sb.append(hashMap.get(num) + " ");
			} else {
				sb.append("0 ");
			}
		}
		System.out.println(sb.toString());
	}
}

/*
 * 분할정복 ver.
public class Main_10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		// 조건에 맞는 값 입력받기
		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[20000001];
		//// 몇개인지 count할 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			cnt[Integer.parseInt(st.nextToken()) + 10000000]++;
			// 10000000 을 더해주는 이유 ? index는 음수일 수 없기 때문
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		// 개수를 찾을 수 입력받기 
		for(int i = 0; i < m; i++) {
			sb.append(cnt[Integer.parseInt(st.nextToken()) + 10000000] + " ");
		}
		System.out.println(sb.toString());
	}
}
*/


