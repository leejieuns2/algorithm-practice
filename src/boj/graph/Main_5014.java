package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014 {
    // 건물의 총 층수 F, 스타트링크의 위치 G, 강호의 위치 S
    // 위로 갈 수 있는 층 수 U, 아래로 갈 수 있는 층수 D
    public static int F, G, S, U, D;
    // 방문 횟수 저장
    public static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new int[F + 1];
        int answer = bfs(S);
        if(answer == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }

    // 최솟값을 찾는 문제이기 때문에 BFS로 문제 해결
    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while(!queue.isEmpty()) {
            int value = queue.remove();
            if(value == G) {
                // 처음에 더해준 값 마지막에 빼기 (출발시점)
                return visited[value] - 1;
            }
            // 내려가는 경우 (0보다는 크고, 방문하지 않은 층수여야 함)
            if(value - D > 0 && visited[value - D] == 0) {
                visited[value - D] = visited[value] + 1;
                queue.add(value - D);
            }
            // 올라가는 경우 (맨 끝층보다는 작아야 하고, 방문하지 않은 층수여야 함)
            if(value + U <= F && visited[value + U] == 0) {
                visited[value + U] = visited[value] + 1;
                queue.add(value + U);
            }
        }
        return -1;
    }
}
