package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 4949. 균형잡힌 세상
 * https://www.acmicpc.net/problem/4949
 * */

public class Main_4949 {

	public static void main(String[] args) throws IOException {
		
		Stack<Character> stack = new Stack<Character>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			String tmp = br.readLine();
			
			// 종료조건
			if(tmp.equals(".")) {
				break;
			}
			
			char[] array = tmp.toCharArray();
			for(int i = 0; i < array.length; i++) {
				switch(array[i]) {
					case'[' :
					case'(' :
						stack.push(array[i]);
						break;
					case ')' :
						if(!stack.isEmpty() && stack.peek() == '(') {
							stack.pop();
						} else {
							stack.push(array[i]);
						}
						break;
					case ']' :
						if(!stack.isEmpty() && stack.peek() == '[') {
							stack.pop();
						} else {
							stack.push(array[i]);
						}
						break;
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			stack.clear();
		}
		br.close();
	}
}
