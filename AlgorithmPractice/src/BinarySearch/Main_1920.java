package BinarySearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1920. 수 찾기 
 * https://www.acmicpc.net/problem/1920
 * https://blockdmask.tistory.com/167 이진 탐색 구현 방법 참고
 * */
public class Main_1920 {

	// Algorithm
	static void solution(int n, int m, int[] a, int[] num) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < m; i++) {
			if(find(a, n, num[i])) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	static boolean find(int[] a, int n, int key) {
		int start = 0;
		int end = n - 1;
		int mid;
		
		while(end - start >= 0) {
			// 중앙값 구하기 
			mid = (start + end) / 2;
			
			if(a[mid] == key) {
				// 키 값을 찾은 경우 
				return true;
			} else if(a[mid] > key) {
				// 키 값보다 큰 경우 
				end = mid - 1;
			} else {
				// 키 값보다 작은 경우 
				start = mid + 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 조건에 맞는 값 입력받기
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이진탐색을 위해 정렬하기 
		Arrays.sort(a);

		int m = Integer.parseInt(br.readLine());
		int[] num = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		solution(n, m, a, num);
	}

}
