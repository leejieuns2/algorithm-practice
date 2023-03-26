package boj.DynamicProgramming;

import java.io.IOException;
import java.util.Scanner;

// boj 실버 1. 오르막 수
// 이 문제의 핵심은 수가 0으로도 시작할 수 있다는 것, 숫자가 같아도 오름치수라는 것.
// 1일때 결과값이 10인 이유는 0~9 를 오르막수로 하기 때문.
// 00 도 오르막수, 11도 오르막수... 이 부분을 생각해서 계산해야 함.
public class Main_11057 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n + 1][10];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for(int k = j; k <= 9; k++) {
                    if(i == 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] += dp[i - 1][k] % 10007;
                    }
                }
            }
        }

        int sum = 0;
        for(int i = 0; i <= 9; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum % 10007);
    }
}
