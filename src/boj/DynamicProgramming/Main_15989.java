package boj.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ 15989 실버 1 : 1,2,3 더하기 4
public class Main_15989 {
    public static int T;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new int[4][10001];

        calculate();
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            stb.append((dp[1][N] + dp[2][N] + dp[3][N]) + "\n");
        }
        System.out.println(stb.toString());
    }
    public static void calculate() {
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[2][2] = 1;
        dp[2][3] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= 10000; i++) {
            // 1이하의 수로의 합, 2이하의 수로의 합, 3이하의 수로의 합 구하기
            dp[1][i] = dp[1][i - 1];
            dp[2][i] = dp[1][i - 2] + dp[2][i - 2];
            dp[3][i] = dp[1][i - 3] + dp[2][i - 3] + dp[3][i - 3];
        }
    }
}
