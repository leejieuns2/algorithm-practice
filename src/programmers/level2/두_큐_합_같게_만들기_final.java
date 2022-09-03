package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

public class 두_큐_합_같게_만들기_final {

    public static void main(String[] args) {

        int[] a1 = {3, 2, 7, 2};
        int[] b1 = {4, 6, 5, 1};
        System.out.println("result 1 : " + solution(a1, b1));

        int[] a2 = {1, 2, 1, 2};
        int[] b2 = {1, 10, 1, 2};
        System.out.println("result 2 : " + solution(a2, b2));

        int[] a3 = {1, 1};
        int[] b3 = {1, 5};
        System.out.println("result 3 : " + solution(a3, b3));

        int[] a4 = {1, 1, 1, 1, 1};
        int[] b4 = {1, 1, 1, 9, 1};
        System.out.println("result 4 : " + solution(a4, b4));
    }

    public static int solution(int[] queue1, int[] queue2) {
        // array to queue
        Queue<Long> q1 = new LinkedList<Long>(Arrays.stream(queue1).mapToObj(Long::new).collect(Collectors.toList()));
        Queue<Long> q2 = new LinkedList<Long>(Arrays.stream(queue2).mapToObj(Long::new).collect(Collectors.toList()));

        long count = q1.size() + q2.size() * 3;

        long sum1 = getSum(q1);
        long sum2 = getSum(q2);

        int answer = 0;
        while (sum1 != sum2) {
            if(sum1 > sum2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
                answer++;
            } else {
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.poll());
                answer++;
            }

            if (answer >= count) {
                answer = -1;
                break;
            }
        }
        System.out.println(q1.toString());
        System.out.println(q2.toString());

        return answer;
    }

    // 두 큐의 원소 합 구하기
    public static long getTotalSum (Queue<Long> q1, Queue<Long> q2) {
        long sum = q1.stream().mapToLong(i -> i).sum() + q2.stream().mapToLong(i -> i).sum() ;
        return sum;
    }

    // 하나의 큐의 합의 결과 리턴해주는 함수
    public static long getSum (Queue<Long> q) {
        long sum = q.stream().mapToLong(i -> i).sum();
        return sum;
    }
}
