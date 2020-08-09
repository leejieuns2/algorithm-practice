package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* 1931. 회의실 배정
 * https://www.acmicpc.net/problem/1931
 * 알고리즘 : https://pangsblog.tistory.com/19 참고함
 * 관련 문법 : https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html 참고함
 */

public class Main_1931 {

	public static int solution(int n, ArrayList<Time> timeList) {
		int cnt = 0; // 계산 결과를 담을 변수 선언
		
		Collections.sort(timeList); // timeList를 끝나는 시간이 이른 순으로 정렬
		int prevEnd = 0;
		for (Time t : timeList) {
			if (prevEnd <= t.getStart()) {
				cnt += 1;
				prevEnd = t.getEnd();
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine()); // 회의의 개수

		// 입력받은 회의의 start & end time (Time Class) 저장하는 ArrayList
		ArrayList<Time> timeList = new ArrayList<Time>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			timeList.add(new Time(start, end));
		}
		System.out.println(solution(n, timeList));
	}
	

}

// Comparable 사용하기
// 예약된 종료시간보다 예약하려는 회의의 시작시간이 더 크거나 같아야 함.
// 예약하려는 종료시간도 예약된 종료시간보다 무조건 같거나 커야한다.
class Time implements Comparable<Time> {
    private int start;
    private int end;
    
    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public int getStart() {
        return this.start;
    }
    
    public int getEnd() {
        return this.end;
    }
    
    // Collections.sort시 정렬 조건을 정의해주는 함수 compareTo
    // Comparable Interface의 내장 메소드
    @Override
    public int compareTo(Time t) {
        if(this.end < t.getEnd()) {
            return -1;
        }else if(this.end == t.getEnd()) {
            if(this.start < t.getStart()) {
                return -1;
            }else if(this.start == t.getStart()) {
                return 0;
            }else {
                return 1;
            }
        }else {
            return 1;
        }
    }
    
    public String toString() {
        return "start : " + this.start + " end : " + this.end;
    }
}
