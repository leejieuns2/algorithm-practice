package programmers.level2;

import java.util.Arrays;
import java.util.HashSet;

public class 영어_끝말잇기 {

    public static void main(String[] args) {
        String[] word1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println("result 1 : " + Arrays.toString(solution(3, word1)));

        String[] word2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        System.out.println("result 2 : " + Arrays.toString(solution(5, word2)));

        String[] word3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println("result 3 : " + Arrays.toString(solution(2, word3)));
        System.out.println("result 3 : " + Arrays.toString(solution(5, word3)));
        System.out.println("result 3 : " + Arrays.toString(solution(13, word3)));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        char check = words[0].charAt(words[0].length() - 1);
        HashSet<String> wordSet = new HashSet<String>();
        for (int i = 0; i < words.length; i++) {
            int len = wordSet.size();
            wordSet.add(words[i]);;
            if(i != 0) {
                // 끝말잇기 제대로 했는지 판별
                if (check == words[i].charAt(0)) {
                    check = words[i].charAt(words[i].length() - 1);
                    // 중복 단어 말했을 때
                    if (wordSet.size() == len) {
                        return calculateAnswer(n, i + 1);
                    }
                } else {
                    return calculateAnswer(n, i + 1);
                }
            }
        }
        return answer;
    }
    // 정답 배열 구하는 함수를 별도로 생성함.
    public static int[] calculateAnswer(int n, int i) {
        int[] answer = new int[2];
        // 이거 식 세우는게 좀 어려웠음.
        answer[0] = (i % n == 0)? n : (i % n);
        answer[1] = (i % n == 0)? (i / n) : ((i / n) + 1);
        return answer;
    }
}
