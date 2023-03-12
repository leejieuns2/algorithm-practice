package boj.in_progress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468 {
    static int[][] map;
    static int N;
    static int max;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        int h_max = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                h_max = Math.max(h_max, map[i][j]);
            }
        }

        for(int h = 1; h <= h_max; h++) {
            int cnt = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] > h && !visited[i][j]) {
                        dfs(i, j, h);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    public static void dfs(int x, int y, int h) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                if(map[nextX][nextY] > h && !visited[nextX][nextY])
                    dfs(nextX, nextY, h);
            }
        }
    }
}
