package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 5212. 실버2 지구 온난화
 */
public class Main_5212 {
    public static int R, C;
    public static char[][] map;
    public static int[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        visited = new int[R][C];
        bfs();
        changeMap();
        printMap();
    }
    public static void bfs() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                char ch = map[i][j];
                int cnt = 0; // 주변의 육지 개수 cnt
                if (ch == '.') {  // 바다인 경우
                    continue;
                } else {
                    // 육지인 경우, 해당 좌표로부터 상,하,좌,우 탐색
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        // 이동 좌표가 범위 내에 있고, 육지라면 count
                        if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                            if (map[nx][ny] == 'X')
                                cnt++;
                        }
                    }
                }
                visited[i][j] = cnt; // 해당 좌표 4 방향의 육지 개수를 저장한다.
            }
        }
    }
    public static void changeMap() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                // 주변에 육지의 개수가 1개 이하라면 3면 이상이 바다이기 때문에 50년 후 바다로 변경
                if(visited[i][j] <= 1) {
                    map[i][j] = '.';
                }
            }
        }
    }
    public static void printMap() {
        // 새롭게 출력해야 하는 지도는 모든 섬을 포함하는 가장 작은 직사각형이어야 함.
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j]=='X') {
                    minX = Math.min(i, minX);
                    maxX = Math.max(i, maxX);

                    minY = Math.min(j, minY);
                    maxY = Math.max(j, maxY);
                }
            }
        }

        // 결과값 출력
        for(int i = minX; i <= maxX; i++) {
            for(int j = minY; j <= maxY; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
