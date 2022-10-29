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
        // stages array -> arrayList로 변경
        ArrayList<Integer> stageList = new ArrayList<>(Arrays.stream(stages).boxed().collect(Collectors.toList()));
        // Index와 실패율 저장하는 Hashmap 생성
        HashMap<Integer, Double> failureRate = new HashMap<>();

        // stageList 정렬
        Collections.sort(stageList);

        for(int i = 1; i <= N; i++) {
            int count = 0;
            if(stageList.contains(i)) {
                // 정렬했으니 같은 스테이지에 있는 사람들의 개수 추출 가능
                count = stageList.lastIndexOf(i) + 1;
                // 실패율 계산을 위해 removeAll 하기 전 size 저장
                int size = stageList.size();
                // 현재 스테이지에 머물러 있는 사람들 전체 제거
                stageList.removeAll(Collections.singleton(i));
                // 실패율 계산해서 Hashmapd에 저장
                Double rate = (double) count / size;
                failureRate.put(i, rate);
                System.out.println(i + " " + count + " " + size);
            } else {
                // 만약 해당 스테이지에 머물러 있는 사람이 한명도 없는 경우
                failureRate.put(i, (double) 0);
            }
        }
        // Hashmap을 실패율(value)를 기준으로 정렬
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(failureRate.entrySet());
        Collections.sort(entryList, Map.Entry.comparingByValue(Comparator.reverseOrder())); // 오름차순으로 정렬
        for(int i = 0; i < N; i++){
            // 최종 answer에 index만 저장
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
