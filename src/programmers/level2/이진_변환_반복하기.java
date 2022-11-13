package programmers.level2;

import java.util.Arrays;

public class 이진_변환_반복하기 {

    public static void main(String[] args) {

        String a1 = "110010101001";
        System.out.println("result 1 : " + Arrays.toString(solution(a1)));

        String a2 = "01110";
        System.out.println("result 2 : " + Arrays.toString(solution(a2)));

        String a3 = "1111111";
        System.out.println("result 3 : " + Arrays.toString(solution(a3)));
    }

    public static int[] solution(String s) {
        int[] answer = {0, 0};
        while(!s.equals("1")) {
            // 이진 변환 시도 횟수 더하기
            answer[0]++;
            int len = s.length();
            s = s.replaceAll("0", "");
            // 0의 갯수 더하기
            answer[1] += len - s.length();
            // 이진 변환
            s = Integer.toBinaryString(s.length());
        }
        return answer;
    }
}
