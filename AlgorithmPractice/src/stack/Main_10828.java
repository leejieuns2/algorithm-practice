package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 10828. 스텍
 * https://www.acmicpc.net/problem/10828
 * */

public class Main_10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		
		while(num != 0) {
			String tmp = br.readLine();
			if(tmp.startsWith("push")) {
				int pNum = Integer.parseInt(tmp.substring(5));
				stack.push(pNum);
			} else if(tmp.startsWith("top")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
			} else if(tmp.startsWith("size")) {
				System.out.println(stack.size());
			} else if(tmp.startsWith("pop")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
			} else if(tmp.startsWith("empty")) {
				if(stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
			num--;
		}
		br.close();
	}
}
