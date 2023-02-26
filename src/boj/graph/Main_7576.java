package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 골드 5. 토마토
public class Main_7576 {
    static int N, M;
    static int[][] store;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<int[]>();

    // 상, 하, 좌, 우 좌표
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        store = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M ; j++) {
                store[i][j] = Integer.parseInt(st.nextToken());
                if (store[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        System.out.println(bfs());
    }
    private static int bfs() {
        while (!queue.isEmpty()) {
            int[] tomato = queue.poll();
            int x = tomato[0];
            int y = tomato[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (store[nx][ny] == 0) {
                    store[nx][ny] = store[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (store[i][j] == 0) {
                    return -1;
                }
                if (max < store[i][j]) {
                    max = store[i][j];
                }
            }
        }
        return max - 1;
    }
}
