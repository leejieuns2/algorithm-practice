package programmers.level1;

import java.util.*;

public class 모의고사 {

    public static void main(String[] args) {

        int[] a1 = {1,2,3,4,5};
        System.out.println("result 1 : " + Arrays.toString(solution(a1)));

        int[] a2 = {1,3,2,4,2};
        System.out.println("result 1 : " + Arrays.toString(solution(a2)));

    }

    public static int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] count = new int[3];

        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] array3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i = 0; i < answers.length; i++) {
            if(array1[i % array1.length] == answers[i]) {
                count[0]++;
            }
            if(array2[i % array2.length] == answers[i]) {
                count[1]++;
            }
            if(array3[i % array3.length] == answers[i]) {
                count[2]++;
            }
        }

        // max 값 찾기
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count.length; i++) {
            if(max <= count[i]) {
                max = count[i];
            }
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i] == max) {
                answer.add(i);
            }
        }
        Collections.sort(answer);

        // index는 0부터 시작하므로 +1 해주어야 함.
        return answer.stream().mapToInt(i -> i + 1).toArray();
    }

}
