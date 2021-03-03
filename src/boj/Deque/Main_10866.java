package boj.Deque;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 10866. 덱
 * https://www.acmicpc.net/problem/10866
 * */
public class Main_10866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Deque<String> deque = new ArrayDeque<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int num = Integer.parseInt(br.readLine());
		
        String str = "";
		int size = 0;
		while(num != 0) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			if(tmp.equals("push_front")) {
				str = st.nextToken();
				deque.addFirst(str);
				size++;
			} else if(tmp.equals("push_back")) {
				str = st.nextToken();
				deque.addLast(str);
				size++;
			} else if(tmp.equals("pop_front")) {
				if(deque.isEmpty() || size <= 0) {
					sb.append("-1" + System.lineSeparator());
				} else {
					sb.append(deque.pollFirst() + System.lineSeparator());
					size--;
				}	
			} else if(tmp.equals("pop_back")) {
				if(deque.isEmpty() || size <= 0) {
					sb.append("-1" + System.lineSeparator());
				} else {
					sb.append(deque.pollLast() + System.lineSeparator());
					size--;
				}	
			} else if(tmp.equals("front")) {
				if(deque.isEmpty() || size <= 0) {
					sb.append("-1" + System.lineSeparator());
				} else {
					sb.append(deque.peekFirst() + System.lineSeparator());
				}
			} else if(tmp.equals("back")) {
				if(deque.isEmpty() || size <= 0) {
					sb.append("-1" + System.lineSeparator());
				} else {
					sb.append(deque.peekLast() + System.lineSeparator());
				}
			} else if(tmp.equals("size")) {
				if(deque.isEmpty()) {
					sb.append("0" + System.lineSeparator());
				} else {
					sb.append(size + System.lineSeparator());
				}
			} else if(tmp.equals("empty")) {
				if(deque.isEmpty() || size <= 0) {
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