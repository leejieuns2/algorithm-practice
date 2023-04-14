package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 16926. 실버2 배열돌리기1
 */
public class Main_16926 {
    public static int N, M, R;
    public static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 배열 입력 받기
        A = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int lines = Math.min(N, M) / 2;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < lines; j++) {
                int tmp = A[j][j];
                for(int k = j + 1;  k < M - j; k++) {
                    A[j][k - 1] = A[j][k];  // 왼쪽으로 이동
                }
                for(int k = j + 1; k < N - j; k++) {
                    A[k - 1][M - 1 - j] = A[k][M - 1 - j];
                }
                for(int k = M - 2 - j; k >= j; k--) {
                    A[N - 1 - j][k + 1] = A[N - 1 - j][k];
                }
                for(int k = N - 2 - j; k >= j; k--) {
                    A[k + 1][j] = A[k][j];
                }
                A[j + 1][j] = tmp;
            }
        }

        // 결과값 출력
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
