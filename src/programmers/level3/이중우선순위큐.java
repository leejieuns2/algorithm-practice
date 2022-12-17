package programmers.level3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    @Test
    public void main() {
        Assert.assertEquals(Arrays.toString(new int[]{0, 0}),
                Arrays.toString(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        Assert.assertEquals(Arrays.toString(new int[]{333, -45}),
                Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        // PriorityQueue 사용하는 것이 핵심인 문제
        // https://coding-factory.tistory.com/603 참고함.
        PriorityQueue<Integer> minQueue = new PriorityQueue();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for(String op : operations) {
            // minQueue, maxQueue에 같이 넣어주고 만약 제거시 같이 제거하는 방식으로 코드 작성
            // poll() : 우선순위 값 반환 및 제거
            // remove() : 제거만
            if(op.equals("D 1")) {
                if(!maxQueue.isEmpty()) {
                    minQueue.remove(maxQueue.poll());
                }
            } else if(op.equals("D -1")) {
                if(!minQueue.isEmpty()) {
                    maxQueue.remove(minQueue.poll());
                }
            } else {
                // string 쪼갠 후 Integer 부분만 Queue에 삽입
                String[] splitStr = op.split(" ");
                int num = Integer.parseInt(splitStr[1]);
                minQueue.add(num);
                maxQueue.add(num);
            }
        }
        // 만약 두 Queue가 비어있지 않을 경우 값이 존재하는 것이므로 제일 우선순위가 높은 숫자가 최댓값/최솟값
        if(!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            answer[0] = maxQueue.peek();
            answer[1] = minQueue.peek();
        }
        return answer;
    }
}
