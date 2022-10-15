package programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class 체육복 {

    public static void main(String[] args) {

        int[] lost1 = {2, 4};
        int[] reserve1 = {1, 3, 5};
        System.out.println("result 1 : " + solution(5, lost1, reserve1));

        int[] lost2 = {2, 4};
        int[] reserve2 = {3};
        System.out.println("result 2 : " + solution(5, lost2, reserve2));

        int[] lost3 = {3};
        int[] reserve3 = {1};
        System.out.println("result 3 : " + solution(3, lost3, reserve3));

        int[] lost4 = {1, 2, 5, 6, 10, 12, 13};
        int[] reserve4 = {2, 3, 4, 5, 7, 8, 9, 10, 11, 12};
        System.out.println("result 4 : " + solution(13, lost4, reserve4));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        // Array to Hashset
        HashSet<Integer> lostSet = new HashSet<>(Arrays.stream(lost).boxed().collect(Collectors.toList()));
        HashSet<Integer> reserveSet = new HashSet<>(Arrays.stream(reserve).boxed().collect(Collectors.toList()));

        // 중복값 Set 만들기
        HashSet<Integer> dupSet = new HashSet<>(reserveSet);
        dupSet.retainAll(lostSet);

        // 중복 제거
        lostSet.removeAll(dupSet);
        reserveSet.removeAll(dupSet);

        // 앞뒤로 확인하여 체육복을 빌려줄 수 있는지 확인.
        for (int i : reserveSet) {
           if (lostSet.contains(i - 1)) {
                if(i == 1) {
                    lostSet.remove(n);
                } else {
                    lostSet.remove(i - 1);
                }
            } else if (lostSet.contains(i + 1)) {
                if(i == n) {
                    lostSet.remove(1);
                } else {
                    lostSet.remove(i + 1);
                }
            }
        }

        // 전체 학생 수에서 lostSet에 남은 학생 수 빼기.
        return n - lostSet.size();
    }

}
