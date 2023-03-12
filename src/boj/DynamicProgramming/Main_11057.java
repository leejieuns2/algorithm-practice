package boj.DynamicProgramming;

import java.io.IOException;
import java.util.Scanner;

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
