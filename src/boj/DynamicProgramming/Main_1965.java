package boj.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 1965 실버 2. 상자 넣기
public class Main_1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 상자의 개수
        int n = Integer.parseInt(br.readLine());
        // 각 상자의 크기 배열
        int[] num = new int[n];
        // 계산된 값을 저장하는 dp 배열
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 최댓값을 저장하는 변수
        int max = 0;
        // 최장 증가 부분 수열 (LIS)를 구하는 문제
        // 입력값을 받은 후 i index까지 연결되는 부분 증가 수열의 길이를 구해 최댓값을 dp 배열에 담음
        // dp 배열의 값들 중 제일 큰 수가 MAX값
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(num[i] > num[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
