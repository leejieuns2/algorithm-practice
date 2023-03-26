package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 14503 골드 5 : 로봇 청소기
public class Main_14503 {
    public static int[][] room;
    public static int[][] visited;
    public static int N, M, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 방의 크기 (N, M)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 로봇 청소기가 있는 칸의 좌표 (R, C)
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        // 처음에 로봇 청소기가 바라보고 있는 방향
        // 0 : 북, 1 : 동, 2 : 남, 3 : 서
        int D = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        visited = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt++;
        dfs(R, C, D);
        System.out.println(cnt);
    }
    // 북, 동, 남, 서
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void dfs(int x, int y, int dir) {
        int nx, ny, cant = 0;
        visited[x][y] = 1;
        for(int i = 0; i < 4; i++) {
            dir = dir - 1 < 0 ? 3 : dir - 1;
            nx = x + dx[dir];
            ny = y + dy[dir];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
            } else if(room[nx][ny] == 0 && visited[nx][ny] == 0) {
                dfs(nx, ny, dir);
                cnt++;
                break;
            }
            cant++;
        }

        x = x - dx[dir];
        y = y - dy[dir];

        if(x < 0 || x >= N || y < 0 || y >= M) {
            return;
        } else if(cant == 4 && room[x][y] == 0) {
            dfs(x, y, dir);
        }
    }
}
