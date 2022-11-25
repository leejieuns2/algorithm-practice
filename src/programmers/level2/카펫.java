package programmers.level2;

import java.util.Arrays;

public class 카펫 {
    public static void main(String[] args) {

        System.out.println("result 1 : " + Arrays.toString(solution(10, 2)));
        System.out.println("result 2 : " + Arrays.toString(solution(8, 1)));
        System.out.println("result 3 : " + Arrays.toString(solution(24, 24)));

    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        // (brown + yellow) == (width * height)
        int total = brown + yellow;
        for(int div = 3; div <= total / 2; div++) {
            if(total % div == 0) {
                // width가 숫자가 더 커야함.
                answer[0] = total / div;
                answer[1] = div;
                // yellow 격자의 개수와 맞는지 한번 더 확인 (total은 맞아도 yellow의 개수가 맞지 않을 수 있기 때문에)
                // 예를 들어 가로가 16이고 세로가 3일 경우 모든 격자의 수는 48이지만 yellow의 개수는 14개이므로 정답이 아님.
                if((answer[0] - 2) * (answer[1] - 2) == yellow) {
                    break;
                }
            }
        }
        return answer;
    }
}
