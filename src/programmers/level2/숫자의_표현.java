package programmers.level2;

public class 숫자의_표현 {

    public static void main(String[] args) {
        System.out.println("result 1 : " + solution(15));
        // System.out.println("result 2 : " + solution(5));
    }

    // 홀수인 약수의 개수가 정답
    public static int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if(i % 2 == 1) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
