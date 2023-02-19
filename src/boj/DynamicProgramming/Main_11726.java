package boj.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 실버 3. 2 * n 타일링
public class Main_11726 {

    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        // n = 1,2,3,4씩 증가함에 따라 결과가 1,2,3,5 로 나옴.
        // f(n) = f(n-1) + f(n-2)
        // topdown 방식
        System.out.println(topdown(N));

        // bottom-up 방식
        /*
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[N]);
         */
    }
    public static int topdown (int N) {
        if(N == 1 || N == 2) {
            dp[N] = N;
        } else if(dp[N] == 0) {
            dp[N] = (topdown(N - 1) + topdown(N - 2)) % 10007;
        }
        return dp[N];
    }
}
