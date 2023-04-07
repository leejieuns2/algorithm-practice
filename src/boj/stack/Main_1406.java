package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// BOJ 1406. 실버2 에디터
public class Main_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // 초기 편집 문자열

        Stack<String> sLeft = new Stack<>(); // 왼쪽 커서
        Stack<String> sRight = new Stack<>(); // 오른쪽 커서
        // 초기 문자열 넣기
        String[] arr = str.split("");
        for(String s : arr) {
            sLeft.push(s);
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String com = br.readLine();
            if (com.equals("L") && !sLeft.empty()) {
                // 커서를 왼쪽으로 한 칸
                sRight.push(sLeft.pop());
            } else if (com.equals("D") && !sRight.empty()) {
                // 커서를 오른쪽으로 한 칸
                sLeft.push(sRight.pop());
            } else if (com.equals("B") && !sLeft.empty()) {
                // 커서 왼쪽에 있는 문자를 삭제
                sLeft.pop();
            } else if (com.contains("P")) {
                // 두번째 입력값을 커서 왼쪽에 추가함
                sLeft.push(String.valueOf(com.charAt(2)));
            }
        }
        // 문자열 합치기
        while (!sLeft.empty()) {
            sRight.push(sLeft.pop());
        }

        // 결과값 출력
        while (!sRight.empty()) {
            System.out.print(sRight.pop());
        }
    }
}
