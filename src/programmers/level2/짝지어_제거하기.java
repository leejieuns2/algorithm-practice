package programmers.level2;

import java.util.Stack;

public class 짝지어_제거하기 {

    public static void main(String[] args) {
        System.out.println("result 1 : " + solution("baabaa"));
        System.out.println("result 2 : " + solution("cdcd"));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
            // 같은 소문자로 이루어져 있지 않을 때까지 stack에서 제거
            while(true) {
                if (stack.size() >= 2) {
                    char tmp1 = stack.pop();
                    char tmp2 = stack.pop();
                    if (tmp1 != tmp2) {
                        // 넣을때는 뽑은 순서 반대로 넣기
                        stack.add(tmp2);
                        stack.add(tmp1);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int solution_30(String s) {
        int answer = 0;
        int idx = 0;
        while (true) {
            System.out.println("start: " + s);
            if(idx < s.length()) {
                if(idx < s.length() - 1 && s.length() >= 2) {
                    String tmp = String.valueOf(s.charAt(idx));
                    String next = String.valueOf(s.charAt(idx + 1));
                    System.out.println("tmp : " + tmp + " next : " + next);
                    if (tmp.equals(next)) {
                        tmp += next;
                        s = s.replaceFirst(tmp, "");
                        System.out.println(s);
                        idx = 0;
                    } else {
                        idx++;
                    }
                } else {
                    break;
                }
            } else if (s.length() == 0) {
                answer = 1;
                break;
            } else {
                break;
            }
        }
        return answer;
    }
}
