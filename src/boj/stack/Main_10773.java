package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * https://gorani95.tistory.com/150 // Java Queue, Stack 라이브러리 관련 링크
 * 10773. 제로
 * https://www.acmicpc.net/problem/10773
 * 시간복잡도 O(n)
 * */
public class Main_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		
		int num = Integer.parseInt(br.readLine());
		int total = 0;
		while(num != 0) {
			String tmp = br.readLine();
			if(tmp.equals("0")) {
				total -= stack.pop();
			} else {
				stack.add(Integer.parseInt(tmp));
				total += Integer.parseInt(tmp);
			}
			num--;
		}
		System.out.println(total);
		br.close();
	}
}
