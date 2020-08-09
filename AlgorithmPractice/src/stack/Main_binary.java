package stack;

import java.util.Arrays;
public class Main_binary {
	
	 public static long solution(int n, int[] times) {
		long answer = 0;
		int p = times.length; // 심사관의 수
		long start = 0;
		
		Arrays.sort(times); // 소요되는 시간을 정렬
	        
		long[] array = new long[n];
		
		for(int i = 0; i < p; i ++) {
			for(int j = 0; j < n; j++) {
				if(times[i] < times[i + 1]) {
					answer += times[i];
				} else {
					answer += (times[i]);
				}
			}
		}
		return answer;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] times = {7, 10};
		System.out.println(solution(6, times));
	}
}
