package programmers.In_progress;

import java.util.Arrays;

public class 소수_찾기 {

    public static void main(String[] args) {
        System.out.println("result 1 : " + solution(10));
        System.out.println("result 2 : " + solution(5));
    }

    public static int solution(int n) {
        int answer = 1;
        for(int i = n; i > 1; i--) {
            int div = 2;
            while (true) {
                if(i == div) {
                    break;
                } else if(i % div == 0) {
                    answer++;
                    break;
                } else {
                    div++;
                }
            }
        }

        return n - answer;
    }
}
