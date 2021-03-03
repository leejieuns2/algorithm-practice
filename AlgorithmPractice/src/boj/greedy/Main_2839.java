package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2839. 설탕 배달
 * https://www.acmicpc.net/problem/2839
 */
public class Main_2839 {

	public static int solution(int n) {
		int cnt = 0;
	
		if((n/5) != 0) {
			cnt += n/5;
			n %= 5;
			System.out.println("cnt : " + cnt);
			if((n/3) != 0) {
				cnt += n/3;
				n %= 3;
				System.out.println("cnt : " + cnt);
				if(n != 0) {
					return -1;
				}
			} else if (n == 0){
				return cnt;
			}
			System.out.println("n : " + n);
		} else if((n/3) != 0) {
				cnt += n/3;
				n %= 3;
				
				if(n != 0) {
					return -1;
				}
		} else if (n == 0){
			return cnt;
		} else {
			return -1;
		}
		return cnt;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(solution(n));
	}
}
