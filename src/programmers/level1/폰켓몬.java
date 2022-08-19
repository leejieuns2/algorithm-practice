package programmers.level1;

import java.util.ArrayList;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] num1 = {3, 1, 2, 3};
        int[] num2 = {3, 3, 3, 2, 2, 4};
        int[] num3 = {3, 3, 3, 2, 2, 2};

        System.out.println(solution(num1));
        System.out.println(solution(num2));
        System.out.println(solution(num3));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        // nums 에서 중복되지 않는 값만을 arrayList에 넣는다.
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!arrayList.contains(nums[i])) {
                arrayList.add(nums[i]);
                // 결과적으로 answer와 arrayList.size()의 값은 동일
                answer++;
            }
        }

        System.out.println(arrayList.toString());

        // N/2 (종류의 최댓값) 과 중복 제거된 arraylist의 길이를 비교해 더 작은 것을 return한다.
        int max_answer = nums.length / 2;
        if(max_answer < answer) {
            return max_answer;
        } else {
            return answer;
        }
    }
}
