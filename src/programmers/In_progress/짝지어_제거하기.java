package programmers.In_progress;

import java.util.Arrays;

public class 짝지어_제거하기 {

    public static void main(String[] args) {
        System.out.println("result 1 : " + solution("baabaa"));
        System.out.println("result 2 : " + solution("cdcd"));
    }

    public static int solution(String s)
    {
        int answer = 0;
        int idx = 0;
        while (true) {
            System.out.println("start: " + s);
            if(idx < s.length()) {
                if(idx < s.length() - 1 && s.length() >= 2) {
                    String tmp = String.valueOf(s.charAt(idx));
                    String next = String.valueOf(s.charAt(idx + 1));
                    System.out.println("tmp : " + tmp + " next : " + next);
                    if (tmp.equals(next)) {
                        tmp += next;
                        s = s.replaceFirst(tmp, "");
                        System.out.println(s);
                        idx = 0;
                    } else {
                        idx++;
                    }
                } else {
                    break;
                }
            } else if (s.length() == 0) {
                answer = 1;
                break;
            } else {
                break;
            }
        }
        return answer;
    }
}
