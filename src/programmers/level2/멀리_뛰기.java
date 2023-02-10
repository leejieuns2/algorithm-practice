package programmers.level2;

import org.junit.Assert;
import org.junit.Test;

public class 멀리_뛰기 {

    @Test
    public void main() {
        Assert.assertEquals(5, solution(4));
        Assert.assertEquals(3, solution(3));
        Assert.assertEquals(13, solution(6));
        Assert.assertEquals(8, solution(5));

    }

    // 같은 것이 있는 순열 문제
    // 근데 알고보니 피보나치 변형,,,,
    long[] memo;
    public long solution(int n) {
        memo = new long[n + 1];
        for(int i = 0; i <= n; i++) {
            if(i <= 2) {
                memo[i] = i;
            } else {
                memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567;
            }
        }
        return memo[n];
    }
    // 처음에는 재귀로 풀어보려 했는데 잘 안됨. (몇몇 케이스 실패)
//    public long fibo(int n) {
//        if(memo[n] != 0) {
//            return memo[n];
//        } else if (n <= 2) {
//            memo[n] = n;
//            return memo[n];
//        } else{
//            memo[n] = (memo[n - 1] + memo[n - 2]) % 1234567;
//
//        }
//        return fibo(n - 1) + fibo(n - 2);
//    }
}
