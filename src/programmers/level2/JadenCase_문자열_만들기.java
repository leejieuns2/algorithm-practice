package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class JadenCase_문자열_만들기 {
    public static void main(String[] args) {
        String word1 = "3people unFollowed me";
        System.out.println("word1 : " + solution(word1));

        String word2 = "for the last week";
        System.out.println("word2 : " + solution(word2));

        String word3 = "A AaAa  AAAa Ba   b BBB";
        System.out.println("word2 : " + solution(word3));
    }

    // split으로 해서 단어별로 쪼개서 해결한 것이 아니라 글자별로 쪼개서 풀었음.
    public static String solution(String s) {
        String answer = "";
        // array -> arraylist로 변경
        ArrayList<String> sList = new ArrayList<>(Arrays.stream(s.split("")).collect(Collectors.toList()));
        // 첫 글자인지를 판별하기 위한 변수 flag 선언
        boolean flag = true;
        for(String str : sList) {
            // 이 경우 공백은 그냥 뛰어넘으면 되므로 공백 계산을 하지 않아도 됨.
            if(str.equals(" ")) {
                flag = true;
                answer += str;
            } else {
                // 공백이 아닐 경우 : 첫글자인 경우 / 숫자인 경우 / 첫글자 & 숫자도 아닌 경우로 나누어 코드 작성
                if(Character.isDigit(str.charAt(0))) {
                    flag = false;
                    answer += str;
                } else {
                    if(flag) {
                        // 첫글자인 경우 대문자로 변경
                        answer += str.toUpperCase();
                        flag = false;
                    } else {
                        // 첫글자가 아닌 경우 소문자로 변경
                        answer += str.toLowerCase();
                    }
                }
            }
        }
        return answer;
    }

    // split으로 시도
    // 공백이 여러개일 경우를 잡지 못해서 44점만 나오는 것으로 추정
    public static String solution_44(String s) {
        String answer = "";
        // 원래는 특정 테스트케이스들에서 런타임 에러가 떴으나 아래 코드 한줄 집어넣었더니 실패로 뜸.
        String newStr = s.replaceAll("\\s+", " ");
        String[] sArray = newStr.split(" ");
        for (int i = 0; i < sArray.length; i++) {
            System.out.println(sArray[i]);
            if(!(sArray[i].charAt(0) - '0' >= 0 && sArray[i].charAt(0) - '0' <= 9)) {
                String firstStr = String.valueOf(sArray[i].charAt(0));
                String remainStr = sArray[i].substring(1).toLowerCase();
                answer += (i == sArray.length - 1)? firstStr.toUpperCase() + remainStr : firstStr.toUpperCase() + remainStr + " ";
            } else {
                answer += (i == sArray.length - 1)? sArray[i] : sArray[i] + " ";
            }
        }
        return answer;
    }
}
