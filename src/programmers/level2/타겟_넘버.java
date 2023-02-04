package programmers.level2;

import org.junit.Assert;
import org.junit.Test;

public class 타겟_넘버 {

    @Test
    public void main() {
        Assert.assertEquals(5,
                solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    public void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){
            // 끝까지 탐색했을 경우
            if(target == sum) {
                answer++;
            }
        } else {
            // 해당 노드의 값을 더하고 다음 깊이 탐색
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            // 해당 노드의 값을 빼고 다음 깊이 탐색
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }
}