package programmers.level1;

import java.util.Arrays;

public class 예산 {

    public static void main(String[] args) {
        int[] d1 = {1,3,2,5,4};
        System.out.println("result 1 : " + solution(d1, 9));

        int[] d2 = {2,2,3,3};
        System.out.println("result 2 : " + solution(d2, 10));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        // 최대한 많이 지원해주려면 예산이 작은 것들부터 넣어야 함.
        // 우선 정렬
        Arrays.sort(d);
        for(int element : d) {
            sum += element;
            if(sum <= budget) {
                answer++;
            }
        }
        return answer;
    }
}
