package boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
BOJ 2075. 실버2 N번째 큰 수
 */
public class Main_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 큰 수부터 빼내야 하므로 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 우선순위 큐에 배열 값 전부 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        // 저장된 큐에서 N번째 수 빼내기
        for(int i = 0; i < N - 1; i++) {
            pq.remove();
        }
        // N번째 큰 수 출력
        System.out.println(pq.remove());
    }
}
