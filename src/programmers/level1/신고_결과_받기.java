package programmers.level1;

import java.util.*;

public class 신고_결과_받기 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        System.out.println("result 1 : " + Arrays.toString(solution(id_list, report, 2)));

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        System.out.println("result 2 : " + Arrays.toString(solution(id_list2, report2, 3)));
    }

    // 각 유저는 한 번에 한 명의 유저를 신고할 수 있다. 신고 횟수의 제한은 없다. 서로 다른 유저를 계속 신고가 가능하다.
    // k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송한다 (신고 기록 저장 필요)
    // 자기 자신을 신고하는 경우는 없음.
    // report에는 공백으로 이용자와 신고한 이용자가 구분됨.
    // return하는 배열은 id_list에 담긴 id 순서대로 각 유저가 받은 결과 메일의 수를 담으면 됨.
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<HashSet<Integer>> reportList = new ArrayList<>();

        // user id와 index를 같이 HashMap에 저장
        Map<String, Integer> user_list = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            user_list.put(id_list[i], i);
        }
        // System.out.println(user_list.toString());

        // reportList 초기화
        reportList.clear();
        for(int i = 0; i < id_list.length; i++) {
            reportList.add(new HashSet<Integer>());
        }

        for(String str : report){
            // 신고자와 신고한 유저가 " "를 구분하여 같이 저장되어 있는 String을 분리해 따로 저장
            String[] sprlit_report = str.split(" ");
            String reporter_id = sprlit_report[0];
            String respondent_id = sprlit_report[1];

            // ex) List(0)의 Hashset에는 0을 신고한 유저들의 index가 저장. 여기서 0은 id_list의 index값
            reportList.get(user_list.get(respondent_id)).add(user_list.get(reporter_id));
        }

        for(int user = 0; user < id_list.length; user++){
            // 유저를 신고한 인원 = set의 사이즈
            // set size가 k보다 크면 메일이 발송됨
            // set안에 들어있는 값들은 해당 user를 신고한 reporter들의 index이므로 answer 배열에 1씩 더해 줌
            if(reportList.get(user).size() >= k){
                for(int reporter : reportList.get(user))
                    answer[reporter]++;
            }
        }
        return answer;
    }
}
