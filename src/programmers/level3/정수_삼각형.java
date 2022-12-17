package programmers.level3;

import org.junit.Assert;
import org.junit.Test;

public class 정수_삼각형 {
    @Test
    public void main() {
        Assert.assertEquals(30,
                solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    public static int[][] dp;
    public int solution(int[][] triangle) {
        dp = new int[triangle.length][triangle.length];
        return calculateSum(0, 0, triangle);
    }
    // 재귀함수를 이용해 DP 구현
    public int calculateSum (int row, int col, int[][] triangle) {
        // range 밖을 벗어나면 안되므로
        if (triangle.length == row) {
            return 0;
        }
        if (dp[row][col] > 0) {
            return dp[row][col];
        }
        return dp[row][col] = triangle[row][col]
                + Math.max(calculateSum(row + 1, col, triangle), calculateSum(row + 1, col + 1, triangle));
    }
}
