package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {

    // 수빈이의 위치, 동생의 위치
    public static int N, K;
    // 점의 위치의 최댓값 저장
    public static int MAX_VALUE = 100000;
    public static int answer = 0;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[MAX_VALUE + 1];
        search(N);
        System.out.println(answer);
    }

    // BFS
    public static void search(int start) {
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;
        while(N != K) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int value = queue.remove();
                visited[value] = true;
                // 만약 연산 결과가 K와 같을 경우 return
                if(value - 1 == K || value + 1 == K || value * 2 == K) {
                    answer = count;
                    return;
                }
                // 경우의 수 계산해서 큐에 저장
                if (value - 1 >= 0 && !visited[value - 1]) {
                    visited[value - 1] = true;
                    queue.add(value - 1);
                }
                if (value + 1 <= MAX_VALUE && !visited[value + 1]) {
                    visited[value + 1] = true;
                    queue.add(value + 1);
                }
                if (value * 2 <= MAX_VALUE && !visited[value * 2]) {
                    visited[value * 2] = true;
                    queue.add(value * 2);
                }
            }
        }
    }
}
