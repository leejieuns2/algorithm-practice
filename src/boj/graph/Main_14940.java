package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940 {

    public static int N, M, cnt;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[][] count;
    public static Queue<Integer> queue= new ArrayDeque<>();

    // 상, 하, 좌, 우 좌표 이동
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        count = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                    visited[i][j] = true;
                }
            }
        }

        search();

        // 결과값 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    sb.append(-1).append(" ");
                }
                else {
                    sb.append(count[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void search () {
        while (!queue.isEmpty()) {
            int x = queue.remove();
            int y = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nX = x + dx[i];
                int nY = y + dy[i];

                if (nX >= 0 && nY >= 0 && nX < N && nY < M) {
                    if(map[nX][nY] == 1 && !visited[nX][nY]) {
                        queue.add(nX);
                        queue.add(nY);
                        visited[nX][nY] = true;
                        count[nX][nY] = count[x][y] + 1;
                    }
                }
            }
        }
    }
}
