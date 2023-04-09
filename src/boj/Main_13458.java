package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ - 13458 (브론즈 2). 시험 감독
public class Main_13458 {
    public static int N, B, C;
    public static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 시험장의 개수

        A = new int[N];    // 각 시험장에 있는 응시자의 수 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());   // 총감독관 : 감시할 수 있는 응시자의 수
        C = Integer.parseInt(st.nextToken());   // 부감독관 : 감시할 수 있는 응시자의 수

        // 결과값을 int가 아닌 long형으로 선언해야 함...
        // 시험장 개수 max * 시험장 당 응시자 수 max > int 범위 이기 때문에
        long rslt = 0;
        for (int i = 0; i < N; i++) {
            rslt += 1;
            A[i] -= B;
            if(A[i] < 0) {
                continue;
            } else {
                rslt += A[i] / C;
                if (A[i] % C > 0) {
                    rslt++;
                }
            }
        }
        System.out.print(rslt);
    }
}
