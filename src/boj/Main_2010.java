package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2010. 플러그
 * https://www.acmicpc.net/problem/2010
 * */


public class Main_2010 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 무조건 1개의 컴퓨터는 꽂을 수 있으므로 초기값 1로 설정
        int total = 1;

        for(int i = 0; i < N; i++) {
            total += Integer.parseInt(br.readLine());
        }

        // 멀티탭(N)을 꽂은 개수만큼은 빼주어야 함.
        total -= N;

        System.out.println(total);
        br.close();
    }
}
