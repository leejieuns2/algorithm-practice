package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
BOJ 1747. 실버1 소수 & 팰린드롬
 */
public class Main_1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (true) {
            // 만약 N == 1일 경우 소수가 아니기 때문에 2를 출력해야 함.
            if (N >= 2 && isPrime(N) && isPalindrome(N)) {
                System.out.println(N);
                break;
            }
            N++;
        }
    }

    // 펠린드롬 판별 함수
    public static boolean isPalindrome(int n) {
        String num = String.valueOf(n);
        int len = num.length();
        for (int i = 0; i <= len / 2; i++) {
            if (num.charAt(i) != num.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 소수 판별 함수
    // 처음에 시간초과 나서 에라토스테네스의 체 활용
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
