package programmers.level2;

import java.util.Arrays;

public class 피보나치_수 {

    public static void main(String[] args) {
        System.out.println("result 1 : " + solution(3));
        System.out.println("result 2 : " + solution(5));
        System.out.println("result 3 : " + solution(25));
        System.out.println("result 3 : " + solution(100));
    }

    public static int solution(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int answer = fib(n, memo);
        System.out.println(Arrays.toString(memo));
        return answer;
    }
    public static int fib(int n, int[] memo) {
        if(memo[n] == -1) {
            if(n == 0) {
                memo[n] = 0;
                return 0;
            } else if (n == 1) {
                memo[n] = 1;
                return 1;
            } else {
                // 항상 값이 int 영역을 벗어나지 않게 하기 위함.
                // 처음에 Long으로 자료형을 변경했으나 똑같이 7번째 테스트케이스 이후 실패.
                // 이유는 피보나치 수열이 워낙 빠르게 숫자가 증가해서 Long으로도 범위를 커버할 수 없음.
                // (A + B) % C = (A % C ) + (B % C) % C
                memo[n] = (fib(n - 1, memo) % 1234567 + fib(n - 2, memo) % 1234567) % 1234567;
                return memo[n];
            }
        } else {
            return memo[n];
        }
    }
}
