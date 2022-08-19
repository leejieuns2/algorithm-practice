package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 없는_숫자_더하기 {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 4, 6, 7, 8, 0};
        int[] num2 = {5, 8, 4, 0, 6, 7, 9};

        System.out.println(solution(num1));
        System.out.println(solution(num2));
    }

    public static int solution(int[] numbers) {
        int answer = 9 * 10 / 2; // (n+1)/2 이용 --> 등차수열

        for(int num : numbers) {
            // for-each문 돌면서 있는 숫자 전체 더한 값에서 빼주기
            answer -= num;
        }

        return answer;
    }
}
