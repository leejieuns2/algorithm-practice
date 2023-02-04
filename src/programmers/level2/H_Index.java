package programmers.level2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class H_Index {

    @Test
    public void main() {
        Assert.assertEquals(3, solution(new int[]{3, 0, 6, 1, 5}));
        Assert.assertEquals(5, solution(new int[]{10, 10, 10, 10, 10}));
    }

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            // 해당 논문보다 인용 횟수가 크거나 같은 논문 편수 H
            int h = citations.length - i;
            // 조건에 첫번째로 부합하는 순간이 H-Index의 최댓값
            if(h <= citations[i]) {
                answer = h;
                return answer;
            }
        }
        return answer;
    }
}
