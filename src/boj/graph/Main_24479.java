package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
* dfs 수도코드
* dfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점
    visited[R] <- YES;  # 시작 정점 R을 방문 했다고 표시한다.
    for each x ∈ E(R)  # E(R) : 정점 R의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
        if (visited[x] = NO) then dfs(V, E, x);
}
* */

public class Main_24479 {

    public static int N, M, R;
    public static int[] visited;
    public static int count;
    public static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점 개수, 간선 개수, 시작 정점 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 방문 여부 체크
        visited = new int[N + 1];

        // 간선 입력값 받기
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 간선이므로 추가
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        count = 1;
        dfs(R);

        for(int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void dfs (int R) {
        visited[R] = count;
        for(int V : graph[R]) {
            // 정점 방문 체크 후 재귀
            if(visited[V] == 0) {
                count++;
                dfs(V);
            }
        }
    }
}
