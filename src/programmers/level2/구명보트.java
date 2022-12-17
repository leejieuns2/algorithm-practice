package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

public class 구명보트 {

    public static void main(String[] args) {

        int[] a1 = {70, 50, 80, 50};
        System.out.println("result 1 : " + solution(a1, 100));

        int[] a2 = {70, 80, 50};
        System.out.println("result 2 : " + solution(a2, 100));

        int[] a3 = {20, 30, 40, 50, 60, 70, 80, 90, 100};
        System.out.println("result 2 : " + solution(a3, 100));

    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        // 정렬
        // 처음에는 Arrays.sort가 아닌 Collection.sort를 사용했는데 효율성에서 케이스 2개가 시간 초과 뜸
        // 혹시나 하고 Arrays.sort로 바꾸고 바로 Deque에 변환한 list를 넣었더니 문제가 해결됐다.
        // 원인은 잘 모르겠으나,,,https://laugh4mile.tistory.com/175 읽어보니 우선 둘의 정렬 알고리즘이 다른 것은 알겠음.
        Arrays.sort(people);
        // Array -> Deque 전환
        Deque<Integer> deque = new ArrayDeque<Integer>(Arrays.stream(people).boxed().collect(Collectors.toList()));


        while(deque.size() >= 2) {
            if(limit >= deque.getFirst() + deque.getLast()) {
                answer++;
                deque.removeFirst();
                deque.removeLast();
            } else {
                answer++;
                deque.removeLast();
            }
        }

        if(!deque.isEmpty()) {
            answer+= deque.size();
        }

        return answer;
    }

    public static int solution_85(int[] people, int limit) {
        int answer = 0;
        boolean[] check = new boolean[people.length];
        Arrays.fill(check, false);
        Arrays.sort(people);
        for(int i = 0; i < people.length; i++) {
            System.out.println("for : " + i);
            for(int j = people.length - 1 - i; j > i; j--) {
                if(!check[j]) {
                    System.out.println(people[i] + ", " + people[j]);
                    int sum = people[i] + people[j];
                    if(limit >= sum) {
                        answer++;
                        check[i] = true;
                        check[j] = true;
                        break;
                    } else {
                        answer++;
                        check[j] = true;
                    }
                }
            }
            if(!check[i]) {
                if(i == 0) {
                    answer = people.length;
                    break;
                } else {
                    answer = people.length - i;
                    break;
                }
            }
        }
        return answer;
    }

    public static int solution_75(int[] people, int limit) {
        int answer = 0;
        ArrayList<Integer> peopleList = (ArrayList<Integer>) Arrays.stream(people).boxed().collect(Collectors.toList());
        while(peopleList.size() > 1) {
            int max = peopleList.stream().max(Comparator.naturalOrder()).get();
            int min = peopleList.stream().min(Comparator.naturalOrder()).get();
            System.out.println(max + " , " + min);
            if(limit >= min + max) {
                answer++;
                peopleList.remove((Integer) min);
                peopleList.remove((Integer) max);
            } else {
                answer++;
                peopleList.remove((Integer) max);
            }
        }
        if(!peopleList.isEmpty()) {
            answer++;
        }
        return answer;
    }
}
