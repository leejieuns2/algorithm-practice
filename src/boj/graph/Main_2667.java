package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2667 {

    // 상, 하, 좌, 우 좌표 이동
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    // 지도의 크기 N
    public static int N, count;
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static boolean[][] visited;
    public static int[][] maps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        maps = new int[N][N];

        // 지도의 자료 입력하기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                maps[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(maps[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }

        // 단지 내 집의 수 오름차순 정렬
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int a : answer) {
            System.out.println(a);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            if (nX >= 0 && nY >= 0 && nX < N && nY < N) {
                if(maps[nX][nY] == 1 && !visited[nX][nY]) {
                    visited[nX][nY] = true;
                    dfs(nX, nY);
                }
            }
        }
    }
}
