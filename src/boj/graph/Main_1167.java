package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1167 {
   static class Node {
        int idx;
        int cnt;
        Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    static int n, max;
    static ArrayList<Node>[] tree;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while(true) {
                int idx = Integer.parseInt(st.nextToken());
                if(idx == -1)
                    break;
                int cnt = Integer.parseInt(st.nextToken());
                tree[start].add(new Node(idx, cnt));
            }
        }
        // 임의의 노드(1)에서 부터 가장 먼 노드를 찾는다. 이때 찾은 노드를 node에 저장한다.
        visited = new boolean[n + 1];
        dfs(1, 0);

        // node에서 부터 가장 먼 노트까지의 거리를 구한다.
        visited = new boolean[n + 1];
        dfs(n, 0);

        System.out.println(max);
    }
    public static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            n = x;
        }
        visited[x] = true;

        for(int i = 0; i < tree[x].size(); i++) {
            Node n = tree[x].get(i);
            if(visited[n.idx] == false) {
                dfs(n.idx, n.cnt + len);
                visited[n.idx] = true;
            }
        }

    }
}
