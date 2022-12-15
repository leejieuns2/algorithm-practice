package programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.stream.Collectors;

public class N개의_최소공배수 {

    public static void main(String[] args) {

        int[] a1 = {2, 6, 8, 14};
        System.out.println("result 1 : " + solution(a1));

        int[] a2 = {1, 2, 3};
        System.out.println("result 2 : " + solution(a2));

        int[] a3 = {3,4,9,16};
        System.out.println("result 3 : " + solution(a3));

    }

    // 유클리드 호제법 사용
    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        System.out.println(stack.toString());
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            stack.add(lcm(a, b));
        }
        return stack.pop();
    }

    public static int solution_20(int[] arr) {
        int answer = 1;

        HashSet<Integer> arrSet = new HashSet<>();
        for(int a : arr) {
            if(isPrime(a)) {
                arrSet.add(a);
            } else {
                for (int i = 1; i < a; i++) {
                    if (a % i == 0) {
                        arrSet.add(i);
                    }
                }
            }
        }

        System.out.println(arrSet.toString());
        for(int num : arrSet) {
            answer *= num;
        }
        return answer;
    }

    public static boolean isPrime(int num) {
        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
