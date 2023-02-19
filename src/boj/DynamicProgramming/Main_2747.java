package boj.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 브론즈 2. 피보나치 수
public class Main_2747 {
    public static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        System.out.println(fibo(N));
    }
    // Top-down 방식
    /*
    public static int fibo(int N) {
        if(N == 0) {
            memo[N] = 0;
        } else if (N == 1 || N == 2) {
            memo[N] = 1;
        } else if (memo[N] == 0){
            memo[N] = fibo(N - 1) + fibo(N - 2);
        }
        return memo[N];
    }
     */
    // Bottom-up 방식
    public static int fibo(int N) {
        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2; i <= N; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[N];
    }
}
