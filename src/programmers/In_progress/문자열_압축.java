package programmers.In_progress;

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

    // 문자열을 1개 이상의 단위로 잘라서 압축
    public static int solution(String s) {
        // 최대 값은 원래의 str 길이를 넘을 수 없으므로
        int answer = s.length();

        // 이 문제는 최대한 루프를 적게 돌게끔 해야함. (이중 for문을 쓰고 있으므로)
        // 반복되는 str의 길이는 str의 길이 / 2 + 1을 넘을 수 없음. (그럼 반복되는 str가 존재할 수 없기 때문에)
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            String prev_str = s.substring(0, i);
            int count = 1;
            String rslt = "";
            String last_str = "";
            for (int j = i; j < s.length(); j += i) {
                // 최대한 루프를 적게 돌기 위해 작성한 코드
                if (j + i > s.length()) {
                    last_str = s.substring(j);
                    continue;
                }
                if (prev_str.equals(s.substring(j, j + i))) {
                    // 똑같은 str 발견 했을 경우 개수 증가
                    count++;
                } else {
                    rslt += prev_str;
                    if (count != 1) {
                        // 앞에 숫자 써주기
                        rslt = count + rslt;
                    }
                    prev_str = s.substring(j, j + i);
                    count = 1;
                }
            }
            rslt += prev_str + last_str;
            if (count != 1) {
                // 압축이 되었을 경우
                rslt = count + rslt;
                System.out.println(rslt);
            }
            System.out.println(rslt);
            answer = Math.min(answer, rslt.length());
        }

        return answer;
    }
}
