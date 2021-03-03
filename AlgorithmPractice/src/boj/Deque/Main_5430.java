package boj.Deque;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 5430. AC 
 * https://www.acmicpc.net/problem/10866
 * */

public class Main_5430 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine()); // test case의 수
		
		for(int i = 0; i < num; i++) {
			String func = br.readLine();
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				sb.append("error\n");
				break;
			}
			
			// 양 옆에 붙어있는 [] 빼기
			String str = "";
			String tmp = "";
			if(n > 0) {
				tmp = br.readLine();
				str  = tmp.substring(1, tmp.length() - 1);
			} else {
			    sb.append("error\n");
			}
			
			// , 를 기준으로 쪼개기
			String[] string = str.split(",");
			
			// 쪼갠 것을 deque 에 넣기
			Deque<String> deque = new ArrayDeque<String>();
			
			for(int j = 0; j < string.length; j++) {
				deque.addLast(string[j]);
			}
			
			boolean reverse = false;
			for(int j = 0; j < func.length(); j++) {
				if(func.charAt(j) == 'R') {
					if(reverse == false) {
						reverse = true;
					} else {
						reverse = false;
					}
				} else if(func.charAt(j) == 'D') {
					if(deque.size() == 0 || deque.isEmpty()) {
						sb.append("error\n");
						break;
					} else {
						if(reverse == false) {
							deque.pollFirst();
						} else {
							deque.pollLast();
						}
					}
				}				
			}
			Deque<String> temp = new ArrayDeque<String>();
			if(deque.size() != 0 && !deque.isEmpty()) {
				if(reverse == true) {
					int size = deque.size();
					for(int j = 0; j < size; j++) {
						temp.addFirst(deque.removeFirst());
					}
					sb.append(temp.toString() + "\n");
				} else {
					sb.append(deque.toString() + "\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}