package programmers.level2;

public class 문자열_압축 {

    public static void main(String[] args) {
        String word1 = "aabbaccc";
        System.out.println(word1);
        System.out.println("word1 : " + solution(word1));

        String word2 = "ababcdcdababcdcd";
        System.out.println(word2);
        System.out.println("word2 : " + solution(word2));

        String word3 = "abcabcdede";
        System.out.println(word3);
        System.out.println("word3 : " + solution(word3));

        String word4 = "abcabcabcabcdededededede";
        System.out.println(word4);
        System.out.println("word4 : " + solution(word4));

        String word5 = "xababcdcdababcdcd";
        System.out.println(word5);
        System.out.println("word5 : " + solution(word5));
    }

    public static int solution(String s) {
        int answer = 1;

        // 압축한 문자열은 전체 문자열의 길이 / 2 를 넘을 수 없으므로
        for(int i = 1; i <= (s.length() / 2) + 1; i++){
            // 압축하는 재귀함수 실행
            int result = getSplitedLength(s, i, 1).length();

            // 결과가 최솟값이면 answer에 저장
            if (i == 1) {
                answer = result;
            } else {
                answer = (answer > result) ? result : answer;
            }
        }

        return answer;
    }

    public static String getSplitedLength(String s, int n, int repeat){
        if(s.length() < n)
            return s;
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n, s.length());

        // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
        if(!postString.startsWith(preString)){
            if(repeat == 1) {
                return result += preString + getSplitedLength(postString, n, 1);
            }
            return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
        }

        return result += getSplitedLength(postString, n, repeat + 1);
    }
}
