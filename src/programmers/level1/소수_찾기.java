package programmers.level1;

import java.util.Arrays;

public class 소수_찾기 {

    public static void main(String[] args) {
        System.out.println("result 1 : " + solution(10));
        System.out.println("result 2 : " + solution(5));
    }

    // 에라토스테네스의 체
    // n의 개수만큼의 배열에서 배수들을 제거하는 방식으로 소수 판별
    public static int solution(int n) {
        int answer = 0;
        int[] nList = new int[n + 1];   // Array 선언
        Arrays.fill(nList, 1);     // Array 초기화


        for(int i = 2; i <= n; i++) {
            if(nList[i] == 0) {
                continue;
            } else {
                for(int j = i; j <= n; j += i) {
                    if(j != i) {
                        nList[j] = 0;
                    }
                }
            }
        }

        for(int i = 2; i <= n; i++) {
            if(nList[i] == 1) {
                System.out.println(i);
                answer++;
            }
        }

        return answer;
    }

    public static int solution_old(int n) {
        int answer = 1;
        for(int i = n; i > 1; i--) {
            int div = 2;
            while (true) {
                if(i == div) {
                    break;
                } else if(i % div == 0) {
                    answer++;
                    break;
                } else {
                    div++;
                }
            }
        }

        return n - answer;
    }
}
