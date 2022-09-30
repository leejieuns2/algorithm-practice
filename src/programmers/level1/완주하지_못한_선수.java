package programmers.level1;

import java.util.*;

public class 완주하지_못한_선수 {

    public static void main(String[] args) {

        String[] a1 = {"leo", "kiki", "eden"};
        String[] b1 = {"kiki", "eden"};

        System.out.println("result 1 : " + solution(a1, b1));

        String[] a2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] b2 = {"marina", "josipa", "nikola", "filipa"};

        System.out.println("result 1 : " + solution(a2, b2));

    }

    public static String solution(String[] participant, String[] completion) {
        // 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int idx = 0; idx < completion.length; idx++) {
            if (!participant[idx].equals(completion[idx])) {
                // 미완주한 사람 발견할 경우 바로 return
               return participant[idx];
            }
        }
        // 배열의 마지막이 미완주한 사람일 경우
        return participant[participant.length - 1];
    }

    // 처음 제출한 코드
    public static String solution_correct(String[] participant, String[] completion) {
        String answer = "";

        // 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        int idx = 0;
        for(idx = 0; idx < participant.length; idx++) {
            if (completion.length == idx || !participant[idx].equals(completion[idx])) {
                break;
            }
        }

        answer = participant[idx];
        return answer;
    }

    // 효율성 0점 코드
    public static String solution_before(String[] participant, String[] completion) {
        String answer = "";

        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(participant));

        for(String person : completion) {
            if(list.contains(person)) {
                list.remove(person);
            }
        }

        answer = list.get(0);
        return answer;
    }

}
