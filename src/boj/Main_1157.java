package boj;

import java.util.Scanner;
// BOJ 1157. 브론즈1 단어 공부
public class Main_1157 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int alpha[] = new int[26];
        String s= input.next();
        int tmp;

        s = s.toUpperCase(); // 대문자로 변환
        for(int i = 0; i < s.length(); i++){
            tmp = s.charAt(i);
            alpha[tmp - 'A']++; // 아스키코드 활용
        }

        int max = 0, idx = 0;
        for(int i = 0; i < alpha.length; i++){
            if(max < alpha[i]){
                max = alpha[i];
                idx = i;
            }
            else if(max == alpha[i]){
                idx = -2; // ? 로 변환하기
            }
        }
        // 결과 도출
        System.out.printf("%s", Character.toString(idx + 'A'));
    }
}
