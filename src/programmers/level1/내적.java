package programmers.level1;

public class 내적 {
    public static void main(String[] args) {

        int[] a1 = {1, 2, 3, 4};
        int[] b1 = {-3, -1, 0, 2};
        System.out.println("result 1 : " + solution(a1, b1));

        int[] a2 = {-1, 0, 1};
        int[] b2 = {1, 0, -1};
        System.out.println("result 2 : " + solution(a2, b2));

    }

    public static int solution(int[] a, int[] b) {
        int answer = calInner(a, b, a.length - 1, b.length - 1);
        return answer;
    }

    // 재귀함수로 풀었는데 너무 어렵게 풀었나 싶기도 함.
    public static int calInner(int[] aList, int[] bList, int a, int b) {
        if(a == 0 && b == 0) {
            return aList[a] * bList[b];
        } else {
            return aList[a] * bList[b] + calInner(aList, bList, a - 1, b - 1);
        }
    }
}
