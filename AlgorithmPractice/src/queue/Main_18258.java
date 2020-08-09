package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 18258. 큐 2
 * https://www.acmicpc.net/problem/18258
 * */

public class Main_18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Queue<String> queue = new LinkedList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int num = Integer.parseInt(br.readLine());
		
		// size, back 모두 내장 메소드 사용 X, 직접 계산해 저장하고 있어야 시간 초과가 발생하지 않음.
		String last = "";
		int size = 0;
		while(num != 0) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			if(tmp.equals("push")) {
				last = st.nextToken();
				queue.offer(last);
				size++;
			} else if(tmp.equals("front")) {
				if(queue.isEmpty() || size == 0) {
					sb.append("-1" + System.lineSeparator());
				} else {
					sb.append(queue.peek() + System.lineSeparator());
				}
			} else if(tmp.equals("back")) {
				if(queue.isEmpty() || size == 0) {
					sb.append("-1" + System.lineSeparator());
				} else {
					sb.append(last + System.lineSeparator());
				}
			} else if(tmp.equals("size")) {
				if(queue.isEmpty()) {
					sb.append("0" + System.lineSeparator());
				} else {
					sb.append(size + System.lineSeparator());
				}
			} else if(tmp.equals("pop")) {
				if(queue.isEmpty() || size == 0) {
					sb.append("-1" + System.lineSeparator());
				} else {
					sb.append(queue.remove() + System.lineSeparator());
					size--;
				}	
			} else if(tmp.equals("empty")) {
				if(queue.isEmpty() || size == 0) {
					sb.append("1" + System.lineSeparator());
				} else {
					sb.append("0" + System.lineSeparator());
				}
			}
			num--;
		}
		System.out.println(sb.toString());
		br.close();
	}
}
