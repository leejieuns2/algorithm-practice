package boj.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 실버 3. 2×n 타일링 2
public class Main_11727 {
    public static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];

        // n = 1,2,3,4씩 증가함에 따라 결과가 1,3,5,11으로 나옴.
        // f(n) = f(n-1) + 2f(n-2)
        // Top-down 방식
        System.out.println(dp(N));
    }
    public static int dp (int N) {
        if(N == 1) {
            memo[N] = 1;
        } else if (N == 2) {
            memo[N] = 3;
        } else if (memo[N] == 0) {
            memo[N] = (dp(N - 1) + 2 * dp(N - 2)) % 10007;
        }
        return memo[N];
    }
}
