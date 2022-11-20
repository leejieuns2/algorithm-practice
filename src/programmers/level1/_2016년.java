package programmers.level1;

import java.time.LocalDate;

public class _2016년 {

    public static void main(String[] args) {

        System.out.println("result 1 : " + solution(5, 24));
        // System.out.println("result 1 : " + solution(5, 24));
    }

    public static String solution(int a, int b) {
        String[] day_of_week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        String answer = "";
        LocalDate date = LocalDate.of(2016, a, b);
        //dayofweek 함수는 1 ~ 7까지 반환되므로 -1 해줘야 원하는 index value 가져올 수 있음.
        answer = day_of_week[date.getDayOfWeek().getValue() - 1];
        return answer;
    }
}
