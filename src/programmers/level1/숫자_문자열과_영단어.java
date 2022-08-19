package programmers.level1;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class 숫자_문자열과_영단어 {

    public static void main(String[] args) {
        String word1 = "one4seveneight";
        System.out.println("word1 : " + solution(word1));

        String word2 = "23four5six7";
        System.out.println("word2 : " + solution(word2));

        String word3 = "2three45sixseven";
        System.out.println("word3 : " + solution(word3));

        String word4 = "123";
        System.out.println("word4 : " + solution(word4));

    }

    // 숫자의 일부 자릿수가 영단어로 바뀌어진 것들을 다시 숫자로 반환해 result 생성
    // s가 zero나 0으로 시작하는 경우는 주어지지 않음

    public static int solution(String s) {
        String[] num_list = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int num = 0; num < num_list.length; num++) {
            s = s.replace(num_list[num], String.valueOf(num));
        }
        return Integer.parseInt(s);
    }


    // 쓰레기 코드,,,ㅋㅋㅋㅋ
    public static int solution1(String s) {
        String answer = "";
        // 숫자로 문자열 쪼개기 (단, 쪼개진 숫자도 받아와야 함. split은 그게 안됨)
        ArrayList<String> str_list = new ArrayList<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(s, "1|2|3|4|5|6|7|8|9", true);
        while (stringTokenizer.hasMoreTokens()) {
            str_list.add(stringTokenizer.nextToken());
        }

        System.out.println(str_list.toString());

        for(String str : str_list) {
            // 숫자일 경우 바로 answer 문자열에 포함
            if(isNum(str)) {
                answer += str;
            } else {
                // 분리된 문자열이 숫자 한개일 경우
                String num = getNum(str);
                if(!num.equals("-1")) {
                    answer += num;
                } else{
                    // 분리된 문자열이 숫자 여러개일 경우
                    // StringTokenizer moreSt = new StringTokenizer(str, "one|two|three|four|five|six|seven|eight|nine", true);
                }
            }
        }
        return Integer.parseInt(answer);
    }

    public static boolean isNum(String str) {
        boolean isNum = str.matches("[1-9]");
        return isNum;
    }

    public static String getNum(String str) {
        switch (str) {
            case "zero":
                return "0";
            case "one":
                return "1";
            case "two":
                return "2";
            case "three":
                return "3";
            case "four":
                return "4";
            case "five":
                return "5";
            case "six":
                return "6";
            case "seven":
                return "7";
            case "eight":
                return "8";
            case "nine":
                return "9";
            default:
                return "-1";
        }
    }
}
