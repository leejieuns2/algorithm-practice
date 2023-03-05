package boj.DynamicProgramming;
import java.io.IOException;
import java.util.Scanner;

// BOJ 1309 실버 1. 동물원
public class Main_1309 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n + 1][3];

        // 첫번째 열에는 이미 사자가 들어가 있다고 가정함.
        dp[1][0] = 1; // 사자가 없을 때
        dp[1][1] = 1; // 1번째 칸에만 사자가 있을 때
        dp[1][2] = 1; // 2번째 칸에만 사자가 있을 때
        for(int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901; // 이전 칸에는 2번째 칸에 있어야 1번째 칸에 넣을 수 있음.
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901; // 이전 칸에는 1번째 칸에 있어야 2번째 칸에 넣을 수 있음.
        }
        int answer = (dp[n][0] + dp[n][1] + dp[n][2]) % 9901;
        System.out.println(answer);
    }
}
