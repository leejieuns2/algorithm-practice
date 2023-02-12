package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// boj 2644. 촌수 계산 (실버 2)
public class Main_2644 {
    public static int N;
    public static int start, end;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 가족의 수
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 촌수를 계산하는 두 가족
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 간선의 수
        int len = Integer.parseInt(br.readLine());

        // graph 초기화
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        };

        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            // 양방향으로 그래프에 추가
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }
        dfs(start, 0);
        System.out.println(answer);
    }
    public static void dfs(int s, int cnt) {
        visited[s] = true;
        for(int x : graph.get(s)){
            if(!visited[x]) {
                if(x == end) {

                    answer = cnt + 1;
                    return;
                }
                dfs(x, cnt + 1);
            }
        }
    }
}
