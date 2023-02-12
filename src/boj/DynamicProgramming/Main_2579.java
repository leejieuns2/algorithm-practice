package boj.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// boj 실버 3. 계단 오르기
public class Main_2579 {
    public static int[] rslt;
    public static int[] stairs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        rslt = new int[N + 1];
        stairs = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        rslt[1] = stairs[1];

        if(N >= 2) {
            rslt[2] = stairs[1] + stairs[2];
        }

        for(int i = 3; i <= N; i++) {
            rslt[i] = Math.max(rslt[i - 2], rslt[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(rslt[N]);
    }
}
