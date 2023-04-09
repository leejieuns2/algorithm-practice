package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ - 2003 (실버 4). 수들의 합 2
public class Main_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 배열 값의 개수
        int M = Integer.parseInt(st.nextToken());   // 합의 값
        int[] A = new int[N];   // 배열 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;    // 경우의 수 cnt
        for(int i = 0; i < N; i++) {
            // 일정 index 의 값이 M과 동일할 수 있으므로 cnt++
            if(A[i] == M) {
                cnt++;
            } else {
                int sum = A[i];
                for(int j = i + 1; j < N; j++) {
                    sum += A[j];
                    if(sum == M) {
                        // 배열의 부분합이 M과 같을 경우 cnt++
                        cnt++;
                        break;
                    } else if (sum > M) {
                        // 배열의 부분합이 M보다 클 경우 빠져나오기
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
