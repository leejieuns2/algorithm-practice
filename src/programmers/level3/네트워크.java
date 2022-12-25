package programmers.level3;

import org.junit.Assert;
import org.junit.Test;

public class 네트워크 {

    @Test
    public void main() {
        Assert.assertEquals(2,
                solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));

        Assert.assertEquals(1,
                solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
    // 검사했는지 확인하는 변수 check
    public static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    // dfs 재귀함수로 문제 해결
    public void dfs(int idx, int[][] computers) {
        visited[idx] = true;
        for(int i = 0; i < computers.length; i++) {
            // 자기 자신 (computer[idx][idx])는 항상 1, 양방향이므로 computer[i][idx] 과 computer[idx][i]값도 동일
            if(idx != i && !visited[i] && computers[idx][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}
