package programmers.level2;

import org.junit.Assert;
import org.junit.Test;

public class 점프와_순간_이동 {

    @Test
    public void main() {
        Assert.assertEquals(2, solution(5));
        Assert.assertEquals(2, solution(6));
        Assert.assertEquals(5, solution(5000));
    }

    public int solution(int n) {
        int ans = 0;

        while(true) {
            if(n == 0) {
                break;
            }
            // 2로 나누어 떨어지지 않을 때에만 건전지 사용했다 가정
            if(n % 2 == 1) {
                ans++;
                n--;
            }
            n = n / 2;
        }
        return ans;
    }

}
