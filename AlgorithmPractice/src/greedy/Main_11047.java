package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 11047. 동전 0
 * https://www.acmicpc.net/problem/11047
 * 시간복찹도 O(n^2)
 */

/*
 * Scanner: space를 모두 경계로 인식. 가공하기 쉽다. 효율 낮음
 * BufferedReader: enter만 경계로 인식. 받은 데이터가 String으로 고정. 입력받은 데이터를 타입 변환/파싱 해야 함. 많은 데이터를 입력받을 경우 효율 좋음
 * 입력값은 무조건 String 타입이기에 하나하나 타입 변환해줘야 함
 * Scanner와 달리 Exception 처리가 자체적으로 되어있지 않기에 따로 Exception 처리해줘야 함
 * 라인 단위로 입력받기 때문에, 한 줄에 공란을 경계로 여러 값이 입력된 경우라면 파싱이 필수 -> StringTokenizer 사용하면 됨
 * System.out.println을 최대한 줄이고 StringBuilder을 활용하자
 * System.out.println가 많을 경우 오버헤드가 쌓여 성능 저하를 초래하기 때문
 * 즉, System.out.println 또한 동기화가 적용되어 있는 것. 그렇기에 작더라도 오버헤드가 발생되게 되는 것
 * 깨알 지식: 프로젝트에서 System.out.println로 로그 남기지 말라는 것이 이 이유 때문이었다
 * */

// 마이너스를 하는 방법으로 했는데 나누기로 바꿔야할듯
public class Main_11047 {

	public static int solution(int n, int k, int[] coin) {
		int cnt = 0; // 동전 개수
		for(int i = n - 1; i >= 0; i--) {
			if(k == 0) {
				return cnt;
			}
			
			int tmp = 0; // 남은 값을 동전으로 나눈 몫을 임시로 저장하는 변수
			tmp = k / coin[i];
			if(tmp > 0) {
				// 만약 몫이 0보다 크면 해당하는 동전으로 가치를 환산할 수 있으므로
				k -= coin[i] * tmp; // 총액에서 해당하는 동전 * 환산 가능 개수를 빼고
				cnt += tmp; // 동전의 개수에 몫을 더한다.
			}
			System.out.println("k : " + k + ", cnt : " + cnt);
		}
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " "); // NumberFormatException, IOException 처리
		int n = Integer.parseInt(st.nextToken()); // 동전의 종류의 수
		int k = Integer.parseInt(st.nextToken()); // 가치의 합
		
		// 동전의 가치를 오름차순으로 입력받음.
		int[] coin = new int[n];
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(solution(n, k, coin));
	}
}

//public static int solution(int n, int k, int[] coin) {
//	int cnt = 0; // 동전 개수
//	for(int i = n - 1; i >= 0; i--) {
//		if(k == 0) {
//			return cnt;
//		}
//		
//		while(true) {
//			k -= coin[i];
//			if(k < 0) {
//				// 만약 잘못된 동전이라면 (현재 금액보다 동전의 가치가 더 클 때)
//				k += coin[i];
//				System.out.println("if");
//				break;
//			}
//			cnt++; // 여기까지 코드가 넘어온다면 현재 금액에서 가장 큰 가치의 동전을 선택한 것
//			System.out.println("k : " + k + ", cnt : " + cnt);
//		}
//	}
//	return cnt;
//}
//
//public static void main(String[] args) throws NumberFormatException, IOException {
//	// TODO Auto-generated method stub
//
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	
//	StringTokenizer st = null;
//	
//	st = new StringTokenizer(br.readLine(), " "); // NumberFormatException, IOException 처리
//	int n = Integer.parseInt(st.nextToken()); // 동전의 종류의 수
//	int k = Integer.parseInt(st.nextToken()); // 가치의 합
//	
//	// 동전의 가치를 오름차순으로 입력받음.
//	int[] coin = new int[n];
//	for(int i = 0; i < n; i++) {
//		coin[i] = Integer.parseInt(br.readLine());
//	}
//	System.out.println(solution(n, k, coin));
//}
