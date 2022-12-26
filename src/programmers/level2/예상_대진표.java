package programmers.level2;

import org.junit.Assert;
import org.junit.Test;

public class 예상_대진표 {

    @Test
    public void main() {
        Assert.assertEquals(3, solution(8, 4, 7));
        Assert.assertEquals(3, solution(8, 4, 5));
    }
    public int solution(int n, int a, int b) {
        int answer = 0;
        while (true) {
            if(a == b) {
                break;
            }
            // 이렇게 나누면 절대로 몫이 0이 나오지도 않고, 아래의 케이스도 만족하는 결과를 만들 수 있음.
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }
        return answer;
    }
    // 4, 5 같이 a - b 의 절댓값이 1이지만 만나지 않는 테스트케이스를 만족하지 못함. (테스트케이스 3개 실패)
    public int solution_88(int n, int a, int b) {
        int answer = 0;
        while (true) {
            answer++;
            if(Math.abs(a - b) == 1) {
                break;
            }
            a = (a % 2 == 0)? Math.max(a / 2, 1) : a / 2 + 1;
            b = (b % 2 == 0)? b / 2 : b / 2 + 1;
            System.out.println("a : " + a + " b : " + b);
        }
        return answer;
    }

}
