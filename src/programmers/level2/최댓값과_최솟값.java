package programmers.level2;

public class 최댓값과_최솟값 {

    public static void main(String[] args) {
        String word1 = "1 2 3 4";
        System.out.println("word1 : " + solution(word1));

        String word2 = "-1 -2 -3 -4";
        System.out.println("word2 : " + solution(word2));

        String word3 = "-1 -1";
        System.out.println("word3 : " + solution(word3));
    }

    public static String solution(String s) {
        String answer = "";

        // 임시로 저장할 변수 min/max 선언.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // 공백을 기준으로 구분되어 있으므로 split으로 나누어 array로 저장
        String[] sArray = s.split(" ");
        for (String str : sArray) {
            // Integer로 변환하여 min/max 판단
            int val = Integer.parseInt(str);
            min = (val < min)? val : min;
            max = (val > max)? val : max;
        }
        // (최소값) (최대값) 형태의 문자열 반환
        answer = min + " " + max;
        return answer;
    }
}
