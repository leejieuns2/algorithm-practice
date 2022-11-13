package programmers.level1;

import java.util.Arrays;

public class 옹알이 {

    public static void main(String[] args) {

        String[] a1 = {"aya", "yee", "u", "maa"};
        System.out.println("result 1 : " + solution(a1));

        String[] a2 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println("result 1 : " + solution(a2));

        String[] a3 = {"wooyemawooye", "mayaa", "ymaeaya"};
        System.out.println("result 1 : " + solution(a3));

    }

    public static int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        // 하나 이상 반복되면 무조건 dupWord에 걸리게 되어 있음.
        String[] dupWords = {"ayaaya", "yeye", "woowoo", "mama"};
        int answer = 0;
        for (String babble : babbling) {
            for (int i = 0; i < words.length; i++) {
                // 중복되는 단어가 없을 경우
                if(!babble.contains(dupWords[i])){
                    // 공백으로 replace를 해야 남은 문자들이 합쳐져 새롭게 단어가 되는 경우 방지 가능.
                    babble = babble.replaceAll(words[i], " ");
                }
                // 만약 다 말을 할 수 있는 단어일 경우 공백만 남으므로 answer++
                if (babble.replaceAll(" ", "").equals("")) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    // 단어가 연속되어 나올 경우 고려 안함.
    public static int solution_55(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (String babble : babbling) {
            for (String word : words) {
                babble = babble.replaceFirst(word, "");
                if(babble.equals("")) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
