package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 9012. 괄호
 * https://www.acmicpc.net/problem/9012
 * */

public class Main_9012 {

	public static void main(String[] args) throws IOException {
		
		Stack<Character> stack = new Stack<Character>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		
		while(num != 0) {
			String tmp = br.readLine();

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
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			stack.clear();
			num--;
		}
		br.close();
	}
}
