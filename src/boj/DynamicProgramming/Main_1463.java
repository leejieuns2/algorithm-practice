package boj.DynamicProgramming;

import java.io.IOException;
import java.util.Scanner;

// boj 실버 3. 1로 만들기
public class Main_1463 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(dp(n, 0));
    }
    // DP 배열을 굳이 써야 하나...?
    public static int dp(int n, int cnt) {
        if(n < 2) {
            return cnt;
        }
        // n % 3, n % 2 를 cnt에 더해주는 것이 곧 1을 빼주는 것과 같음.
        return Math.min(dp(n / 3, cnt + 1 + (n % 3)), dp(n / 2, cnt + 1 + (n % 2)));
    }
}
