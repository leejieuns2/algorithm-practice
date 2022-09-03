package programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기 {

    public static void main(String[] args) {

        String[] survey1 = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices1 = {5, 3, 2, 7, 5};
        System.out.println("result 1 : " + solution(survey1, choices1));

        String[] survey2 = {"TR", "RT", "TR"};
        int[] choices2 = {7, 1, 3};
        System.out.println("result 2 : " + solution(survey2, choices2));
    }

    enum Choice {
        TOTALLY_DISAGREE(3), DISAGREE(2), SLIGHTLY_DISAGREE(1),
        UNKNOWN(0),
        SLIGHTLY_AGREE(1), AGREE(2), TOTALLY_AGREE(3);

        public final int score;

        Choice(int score) {
            this.score = score;
        }

        int getScore() { return score; }
    }

    public static String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> typeMap = new HashMap<>();
        for (int idx = 0; idx < choices.length; idx++) {
            Choice choice = getChoice(choices[idx]);
            // survey 원소 쪼개기, type.name 넣어주기
            if (choices[idx] <= Choice.UNKNOWN.ordinal()) {
                String key = survey[idx].substring(0, 1);
                if(typeMap.containsKey(key)) {
                    int score = typeMap.get(key) + choice.getScore();
                    typeMap.replace(key, score);
                } else {
                    typeMap.put(key, choice.getScore());
                }
            } else {
                String key = survey[idx].substring(1);
                if(typeMap.containsKey(key)) {
                    int score = typeMap.get(key) + choice.getScore();
                    typeMap.replace(key, score);
                } else {
                    typeMap.put(key, choice.getScore());
                }
            }
        }
        String answer = getHighestType(typeMap);
        return answer;
    }

    public static String  getHighestType (HashMap<String, Integer> typeMap) {
        String[][] type_list = { {"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"} };
        String answer = "";
        for (String[] type : type_list) {
            if(!typeMap.containsKey(type[0])) {
                typeMap.put(type[0], 0);
            }
            if (!typeMap.containsKey(type[1])) {
                typeMap.put(type[1], 0);
            }

            if (typeMap.get(type[0]) >= typeMap.get(type[1])) {
                answer += type[0];
            } else {
                answer += type[1];
            }
        }
        return answer;
    }

    public static Choice getChoice (int choice) {
        switch (choice) {
            case 1:
                return Choice.TOTALLY_DISAGREE;
            case 2:
                return Choice.DISAGREE;
            case 3:
                return Choice.SLIGHTLY_DISAGREE;
            case 4:
                return Choice.UNKNOWN;
            case 5:
                return Choice.SLIGHTLY_AGREE;
            case 6:
                return Choice.AGREE;
            case 7:
                return Choice.TOTALLY_AGREE;
            default:
                return Choice.UNKNOWN;
        }
    }

}
