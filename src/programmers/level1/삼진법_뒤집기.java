package programmers.level1;

public class 삼진법_뒤집기 {
    public static void main(String[] args) {
        System.out.println("result 1 : " + solution(45));
        System.out.println("result 2 : " + solution(125));
        System.out.println("result 3 : " + solution(1252345567));
    }

    public static int solution(int n) {
        int answer = 0;
        String radix = Integer.toString(n, 3);
        System.out.println(radix);
        String rslt = "";
        for(int i = radix.length() - 1; i >= 0; i--) {
            char s = radix.charAt(i);
            rslt += s;
        }
        // 0을 굳이 제거하지 않아도 parseInt 함수 사용 가능
        answer = Integer.parseInt(rslt, 3);
        return answer;
    }

    // 0을 다 빼버리기 때문에 정답이 제대로 나오지 않음. 앞에 있는 0만 제거하고 해야함.
    public static int solution_30(int n) {
        int answer = 0;
        String radix = Integer.toString(n, 3);
        String rslt = "";
        for(int i = radix.length() - 1; i >= 0; i--) {
            char s = radix.charAt(i);
            if (s != '0') {
                rslt += s;
            }
        }
        answer = Integer.parseInt(rslt, 3);
        return answer;
    }
}
