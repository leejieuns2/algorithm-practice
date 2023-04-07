package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// boj 실버 1. 영역 구하기
public class Main_2583 {
    public static boolean[][] graph;
    public static List<Integer> list;
    public static int count = 0;
    public static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        graph = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            int m2 = Integer.parseInt(st.nextToken()) - 1;
            // 입력받은 좌표를 기준으로 직사각형 내부를 다 true로 처리
            for (int j = m1; j <= m2; j++) {
                for (int k = n1; k <= n2; k++) {
                    graph[j][k] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!graph[i][j]) {
                    count = 1;
                    graph[i][j] = true;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // 각 영역의 넓이를 오름차순으로 정렬
        Collections.sort(list);
        // 첫째줄에는 영역의 개수 반환
        sb.append(list.size() + "\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + " ");
        }
        System.out.print(sb);
    }
    public static void dfs(int x, int y) {
        if (x > 0 && !graph[x - 1][y]) {
            graph[x - 1][y] = true;
            dfs(x - 1, y);
            count++;
        }
        if (x < M - 1 && !graph[x + 1][y]) {
            graph[x + 1][y] = true;
            dfs(x + 1, y);
            count++;
        }
        if (y > 0 && !graph[x][y - 1]) {
            graph[x][y - 1] = true;
            dfs(x,y - 1);
            count++;
        }
        if (y < N - 1 && !graph[x][y + 1]) {
            graph[x][y + 1] = true;
            dfs(x, y + 1);
            count++;
        }
    }
}
