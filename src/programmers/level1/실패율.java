package programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class 실패율 {
    public static void main(String[] args) {

        int[] stage1 = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println("result 1 : " + Arrays.toString(solution(5, stage1)));

        int[] stage2 = {4,4,4,4,4};
        System.out.println("result 2 : " + Arrays.toString(solution(4, stage2)));

        int[] stage3 = {1,1,1};
        System.out.println("result 3 : " + Arrays.toString(solution(3, stage3)));

    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Integer> stageList = new ArrayList<>(Arrays.stream(stages).boxed().collect(Collectors.toList()));
        HashMap<Integer, Double> failureRate = new HashMap<>();

        Collections.sort(stageList);
        for(int i = 1; i <= N; i++) {
            int count = 0;
            if(stageList.contains(i)) {
                count = stageList.lastIndexOf(i) + 1;
                int size = stageList.size();
                stageList.removeAll(Collections.singleton(i));
                Double rate = (double) count / size;
                failureRate.put(i, rate);
                System.out.println(i + " " + count + " " + size);
            } else {
                failureRate.put(i, (double) 0);
            }
        }
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(failureRate.entrySet());
        Collections.sort(entryList, Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for(int i = 0; i < N; i++){
            answer[i] = entryList.get(i).getKey();
            System.out.println("key : " + entryList.get(i).getKey() + ", value : " + entryList.get(i).getValue());
        }
        return answer;
    }

    public static int[] solution_70(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Integer> stageList = new ArrayList<>(Arrays.stream(stages).boxed().collect(Collectors.toList()));
        HashMap<Integer, Double> failureRate = new HashMap<>();

        Collections.sort(stageList);
        for(int i = 1; i <= N; i++) {
            int count = stageList.lastIndexOf(i) + 1;
            int size = stageList.size();
            stageList.removeAll(Collections.singleton(i));
            Double rate = (double) count / size;
            failureRate.put(i, rate);
            System.out.println(i + " " + count + " " + size);
        }
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(failureRate.entrySet());
        Collections.sort(entryList, Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for(int i = 0; i < N; i++){
            answer[i] = entryList.get(i).getKey();
            System.out.println("key : " + entryList.get(i).getKey() + ", value : " + entryList.get(i).getValue());
        }
        return answer;
    }
}
