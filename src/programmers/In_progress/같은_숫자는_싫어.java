package programmers.In_progress;

import java.util.ArrayList;
import java.util.Arrays;

public class 같은_숫자는_싫어 {

    public static void main(String[] args) {

        int[] a1 = {1,1,3,3,0,1,1};
        System.out.println("result 1 : " + Arrays.toString(solution(a1)));

        int[] a2 = {4,4,4,3,3};
        System.out.println("result 1 : " + Arrays.toString(solution(a2)));

    }

    // 숫자 0-9로 이루어진 배열 arr
    // 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거.
    // 단, 제거된 후 남은 수들을 반환할 때에는 순서 유지
    public static int[] solution(int []arr) {
        ArrayList<Integer> answer_list = new ArrayList<>();

        int post_value = -1;
        for(int a : arr) {
            if (post_value != a) {
                answer_list.add(a);
                post_value = a;
            }
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        // list를 stream으로 가져온 후, mapToInt 함수로 Integer -> Int로 언박싱(unboxing)
        // toArray 함수로 언박싱한 값들을 array로 변환하여 가져오기
        int[] answer = answer_list.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
