package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 1541. 잃어버린 괄호
 * https://www.acmicpc.net/problem/1541
 */

public class Main_1541 {

	public static int solution(StringTokenizer sb) {

		int rslt = 0; // 계산 결과를 담을 변수 선언
		
		// - 기호가 나오면 무조건 괄호를 묶어서 최대한 마이너스로 만들어 줘야 최소값을 만들 수 있음.
		// 괄호 속 계산식들을 담을 ArrayList 생성
		ArrayList<String> formula = new ArrayList<String>();
		
		// - 기준으로 문자열 쪼개기
		while(sb.hasMoreTokens()) {
			formula.add(sb.nextToken());
		}
		
		for(int i = 0; i < formula.size(); i++) {
			int tmp = 0;
			
			// 괄호 속에 + 가 있을 경우 쪼개기
			String[] num = formula.get(i).split("\\+");
			
			// 쪼갠 식 더하기
			for(int j = 0; j < num.length; j++) {
				tmp += Integer.parseInt(num[j]);
			}
			
			// 첫번째 값일 경우 양수, 그 외에는 음수가 되어야 하므로
			if(i == 0) {
				rslt += tmp;
			} else {
				rslt -= tmp;
			}
		}
		return rslt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sb = new StringTokenizer(br.readLine(), "-");
		
		System.out.println(solution(sb));
	}

}
