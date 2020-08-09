package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 1874. 스텍 수열
 * https://www.acmicpc.net/problem/1874
 * */

public class Main_1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		int[] array = new int[num];
		
		for(int i = 0; i < num; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		int tmp = 1; // 스텍에 담아야 하는 숫자를 의미함.
		int index = 0; // 만들어야 하는 수열을 담은 array의 index
		while(index < num) {
			
			if(stack.isEmpty()) {
				stack.push(tmp);
				sb.append("+" + System.lineSeparator());
				tmp++;
			} else {
				if (array[index] < stack.peek()) {
					sb.delete(0, sb.length());
					sb.append("NO");
					break;
				}
			}
			
			if (array[index] == stack.peek()) {
				stack.pop();
				sb.append("-" + System.lineSeparator());
				index++;
				// System.lineSeparator() 는 Stringbuilder에 개행문자를 추가시켜 주는 함수
				// 이걸 추가해줘야 toString 호출 시 개행 된 상태로 출력됨.
			} else {
				stack.push(tmp);
				tmp++;
				sb.append("+" + System.lineSeparator());
			}
		}	
		System.out.println(sb.toString());
		br.close();
	}
}
