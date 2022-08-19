package programmers.level1;

public class 음양_더하기 {

    public static void main(String[] args) {

        int[] num1 = {4, 7, 12};
        boolean[] sign1 = {true, false, true};
        System.out.println("result 1 : " + solution(num1, sign1));

        int[] num2 = {1, 2, 3};
        boolean[] sign2 = {false, false, true};
        System.out.println("result 2 : " + solution(num2, sign2));

    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int idx = 0 ; idx < absolutes.length; idx++) {
            if(!signs[idx]) {
                // 음수일경우
                answer -= absolutes[idx];
            } else {
                // 양수일경우
                answer += absolutes[idx];
            }
        }
        return answer;
    }
}
