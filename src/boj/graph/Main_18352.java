package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18352 {
    // 도시의 개수, 도로의 개수, 거리 정보, 출발 도시의 번호
    // 정점의 개수, 간선의 개수, 최단 거리 정보, 시작 정점
    public static int N, M, K, X;
    public static ArrayList<Integer>[] graph;
    public static int[] distance;
    public static Deque<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점 개수, 간선 개수, 거리 정보, 시작 정점 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력값 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 단방향 간선
            graph[u].add(v);
        }

        queue = new ArrayDeque<>();
        distance = new int[N + 1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        bfs(X);

        int count = 0;
        for(int i = 0; i <= N; i++) {
            if(distance[i] == K) {
                count++;
                System.out.println(i);
            }
        }
        if(count == 0) {
            System.out.println("-1");
        }
    }

    public static void bfs(int R) {
        queue.addLast(R);
        distance[R] = 0;
        while (!queue.isEmpty()) {
            int current = queue.removeFirst();
            for (int V : graph[current]) {
                if (distance[V] == Integer.MAX_VALUE) {
                    distance[V] = distance[current] + 1;
                    queue.addLast(V);
                }
            }
        }
    }
}