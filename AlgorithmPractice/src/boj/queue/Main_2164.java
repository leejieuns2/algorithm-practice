package boj.queue;

import java.io.*;
import java.util.*;

/*
 * 2164. 카드 2
 * https://www.acmicpc.net/problem/2164
 * */

public class Main_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			queue.add(i + 1);
		}
		
		for(int i = 0; i < n; i++) {
			if(queue.size() == 1) {
				System.out.println(queue.remove());
				break;
			}
			queue.remove();
			queue.add(queue.remove());
		}
		br.close();
	}
}
