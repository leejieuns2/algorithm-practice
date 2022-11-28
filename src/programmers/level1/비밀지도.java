package programmers.level1;

import java.util.Arrays;

public class 비밀지도 {

    public static void main(String[] args) {

        int[] a1 = {9, 20, 28, 18, 11};
        int[] a2 = {30, 1, 21, 17, 28};
        System.out.println("result 1 : " + Arrays.toString(solution(5, a1, a2)));

        int[] b1 = {46, 33, 33 ,22, 31, 50};
        int[] b2 = {27 ,56, 19, 14, 14, 10};
        System.out.println("result 2 : " + Arrays.toString(solution(6, b1, b2)));

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        // 함수는 알고 있었는데 이런식으로도 쓰임이 가능한 줄 몰랐음.
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        // replace로 한번에 처리한 것이 코드가 깔끔하다.
        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }
        return result;
    }
}
