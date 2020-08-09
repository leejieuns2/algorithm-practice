package queue;

import java.io.*;
import java.util.*;

/*
 * 11866. 요세푸스 문제 0
 * https://www.acmicpc.net/problem/11866
 * */

public class Main_11866 {
	
	public static Queue<Integer> queue = new LinkedList<Integer>();
	public static Queue<Integer> queue2 = new LinkedList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if(j % k == 0) {
					queue2.add(queue.poll());
				}else {
					// 다시 k번째 수를 정해야 하므로 남은 수를 queue에 저장
					queue.add(queue.poll());
				}
			}
		}
		//출력 문자열 생성
		printResult(n);
	}   
	private static void printResult(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i = 1; i <= n; i++) {
			sb.append(queue2.poll());
			if(i != n) {
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
}
