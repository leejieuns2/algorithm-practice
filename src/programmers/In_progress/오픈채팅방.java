package programmers.In_progress;

import java.util.*;

public class 오픈채팅방 {

    public static void main(String[] args) {
        String[] str1 = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution(str1)));
    }

    // 모든 유저는 유저 아이디로 구분한다. (key값은 유저 아이디)
    // Enter, Leave, Change 세 가지 유형으로 나뉨.
    // record 배열 쪼개기 (행동, 유저 아이디, 닉네임 / 공백 기준으로)
    // 유저 아디이와 닉네임은 알파벳 대문자, 소문자를 구별함.

    private static class User {
        String id;
        String nickname;

        User(String id, String nickname) {
            this.id = id;
            this.nickname = nickname;
        }
    }

    private static class Result {
        String userId;
        String action;

        Result(String userId, String action) {
            this.userId = userId;
            this.action = action;
        }
    }

    public static String[] solution(String[] record) {
        // ID, Nickname 저장할 Hashmap
        HashMap<String, User> userMap = new HashMap<>();
        ArrayList<Result> rsltList = new ArrayList<>();
        for(String str : record) {
            String[] split_str = str.split(" ");

            // split_str[0] : 행동, split_str[1] : ID , split_str[2] : Nickname
            switch (split_str[0]) {
                case "Enter" :
                    User newUser = new User(split_str[1], split_str[2]);
                    userMap.put(newUser.id, newUser);
                    rsltList.add(new Result(newUser.id, split_str[0]));
                    break;
                case "Leave" :
                    User findUser = userMap.get(split_str[1]);
                    rsltList.add(new Result(findUser.id, split_str[0]));
                    break;
                case "Change" :
                    User changeUser = userMap.get(split_str[1]);
                    changeUser.nickname = split_str[2];
                    break;
            }

        }

        String[] answer = new String[rsltList.size()];
        int idx = 0;
        for(Result rslt : rsltList) {
            User rsltUser = userMap.get(rslt.userId);
            switch (rslt.action) {
                case "Enter" :
                    answer[idx++] = getEnterStr(rsltUser.nickname);
                    break;
                case "Leave" :
                    answer[idx++] = getLeaveStr(rsltUser.nickname);
                    break;
            }
        }
        return answer;
    }

    public static String getEnterStr(String nickname) {
        return nickname + "님이 들어왔습니다.";
    }

    public static String getLeaveStr(String nickname) {
        return nickname + "님이 나갔습니다.";
    }

    /*
    * 수정 전 코드
    * */

    public static String addRslt (String id, String action) {
        return id + " " + action;
    }

    public static String getEnterStr_before(HashMap<String, String> user, String id) {
        return user.get(id) + "님이 들어왔습니다.";
    }

    public static String getLeaveStr_before(HashMap<String, String> user, String id) {
        return user.get(id) + "님이 나갔습니다.";
    }

    public static String[] solution_before(String[] record) {
        // ID, Nickname 저장할 Hashmap
        HashMap<String, String> user = new HashMap<>();
        ArrayList<String> rslt = new ArrayList<>();
        for(String str : record) {
            String[] split_str = str.split(" ");

            // split_str[0] : 행동, split_str[1] : ID , split_str[2] : Nickname
            switch (split_str[0]) {
                case "Enter" :
                    user.put(split_str[1], split_str[2]);
                    rslt.add(addRslt(split_str[1], split_str[0]));
                    break;
                case "Leave" :
                    rslt.add(addRslt(split_str[1], split_str[0]));
                    break;
                case "Change" :
                    user.replace(split_str[1], split_str[2]);
            }

        }

        System.out.println(user.toString());

        String[] answer = new String[rslt.size()];
        for(int i = 0; i < rslt.size(); i++) {
            String[] str = rslt.get(i).split(" ");
            switch (str[1]) {
                case "Enter" :
                    answer[i] = getEnterStr_before(user, str[0]);
                    break;
                case "Leave" :
                    answer[i] = getLeaveStr_before(user, str[0]);
                    break;
            }
        }
        return answer;
    }
}
