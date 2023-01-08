package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2606 {

    public static int com, nw;
    public static boolean[] visited;
    public static ArrayList<Integer>[] graph;
    public static Deque<Integer> queue;
    // 웜 바이러스에 걸리게 되는 컴퓨터의 수 출력
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터의 개수(정점), 컴퓨터 쌍의 수(간선)
        com = Integer.parseInt(br.readLine());
        nw = Integer.parseInt(br.readLine());

        graph = new ArrayList[com + 1];
        for(int i = 1; i <= com; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력값 받기
        for(int i = 0; i < nw; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 간선이므로 추가
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= com; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[com + 1];
        queue = new ArrayDeque<>();
        bfs(1);

        System.out.println(count);
    }
    public static void bfs(int start) {
        queue.addLast(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int current = queue.removeFirst();
            for(int V : graph[current]) {
                // 방문하지 않은 간선일 경우
                if(!visited[V]) {
                    // 바이러스에 걸린 컴퓨터의 수 추가
                    count++;
                    visited[V] = true;
                    queue.addLast(V);
                }
            }
        }
    }
}
