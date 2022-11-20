package programmers.level1;

import java.util.*;

public class 문자열_내_마음대로_정렬하기 {

    public static void main(String[] args) {

        String[] a1 = {"sun", "bed", "car"};
        System.out.println("result 1 : " + Arrays.toString(solution(a1, 1)));

        String[] a2 = {"abce", "abcd", "cdx"};
        System.out.println("result 1 : " + Arrays.toString(solution(a2, 2)));

    }

    // comparator를 직접 구현해 문제를 해결해보려고 함.
    // 람다식을 이용해 직접 구현하는 방법이 있어 그 방법으로 간단하게 해결.
    // 참고 : https://codechacha.com/ko/java-sorting-comparator/
    public static String[] solution(String[] strings, int n) {
        // n번째 문자열이 같을 경우 사전 순서대로로 정렬해야 하기 때문에 일단 우선 정렬.
        Arrays.sort(strings);
        Arrays.sort(strings, (s1, s2) -> s1.charAt(n) - s2.charAt(n));
        return strings;
    }

    // 비교 대상만 따로 배열로 분리해서 index를 가지고 문제를 해결해보려고 했으나 비교 대상이 같을때 어떻게 해야할지 모르겠어서 포기
    public static String[] solution_old(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Arrays.sort(strings);
        char[] value = new char[strings.length];
        for(int i = 0; i < strings.length; i++) {
            value[i] = strings[i].charAt(n);
        }
        Arrays.sort(strings);
        for (int i = 0; i < answer.length; i++) {
            for(int j = 0; j < answer.length; j++) {
                if(value[i] == strings[j].charAt(n)) {
                    answer[i] = strings[j];
                    break;
                }
            }
        }
        return answer;
    }
}
