package programmers.level2;

public class 다음_큰_숫자 {

    public static void main(String[] args) {

        System.out.println("result 1 : " + solution(78));
        System.out.println("result 2 : " + solution(15));

    }

    public static int solution(int n) {
        int answer = n;
        // 정수를 매개변수로 넣었을 때 정수의 true bit (1)의 개수를 반환해주는 함수.
        // replaceAll(), length() 함수를 거칠 필요 없이 bitCount() 함수 하나로 이진수의 1의 개수를 구할 수 있음.
        int n_count0 = Integer.bitCount(n);
        while(true) {
            answer++;
            int answer_count0 = Integer.bitCount(answer);
            if(n_count0 == answer_count0) {
                break;
            }
        }
        return answer;
    }

    // 효율성 0점 코드
    public static int solution_70(int n) {
        int answer = n;
        int n_count0 = Integer.toBinaryString(n).replaceAll("0", "").length();
        while(true) {
            answer++;
            int answer_count0 = Integer.toBinaryString(answer).replaceAll("0", "").length();
            if(n_count0 == answer_count0) {
                break;
            }
        }
        return answer;
    }

}
