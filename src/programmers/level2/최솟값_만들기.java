package programmers.level2;

import java.util.Arrays;
import java.util.Collections;

public class 최솟값_만들기 {

    public static void main(String[] args) {

        int[] a1 = {1, 4, 2};
        int[] b1 = {5, 4, 4};
        System.out.println("result 1 : " + solution(a1, b1));

        int[] a2 = {1, 2};
        int[] b2 = {3, 4};
        System.out.println("result 1 : " + solution(a2, b2));

    }

    // 최솟값 * 최댓값 이렇게 곱해야 최소합이 나옴.
    public static int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        // Boxing 안하고도 코드 작성 가능
        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }

    // 효율성 하나 실패뜨는 코드
    public static int solution_92(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        // 역순정렬은 Integer로 Boxing 해주어야 가능.
        Integer[] B_box = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(B_box, Collections.reverseOrder());

        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B_box[i];
        }

        return answer;
    }
}
