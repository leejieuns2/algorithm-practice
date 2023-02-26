package boj.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 실버 2. 이동하기
public class Main_11048 {
    static int N, M;
    static int[][] map;
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M ; j++) {
                // 오른쪽, 아래쪽, 대각선으로만 이동 가능하기 때문에 그 값들만 비고하여 최댓값을 Max에 더해줌.
                // for문 하나에 코드를 합칠수도 있지만, 우선은 입력과 계산을 분리함.
                max = Math.max(map[i][j - 1], Math.max(map[i - 1][j - 1], map[i - 1][j]));
                map[i][j] += max;
            }
        }
        System.out.println(map[N][M]);
    }
}
