package programmers.level2;

import java.util.Stack;

public class 올바른_괄호 {

    public static void main(String[] args) {
        String word1 = "()()";
        System.out.println("word1 : " + solution(word1));

        String word2 = "(())()";
        System.out.println("word2 : " + solution(word2));

        String word3 = ")()(";
        System.out.println("word3 : " + solution(word3));

        String word4 = "(()(";
        System.out.println("word4 : " + solution(word4));
    }

    public static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        for(int i = 0; i < sArray.length; i++) {
            if(stack.isEmpty()) {
                if(sArray[i] == '(') {
                    stack.add('(');
                } else {
                    // 빈 스택에 ) 이 먼저 들어갈 경우 짝이 맞지 않음.
                    answer = false;
                    break;
                }
            } else {
                if(sArray[i] == '(') {
                    stack.add('(');
                } else if(sArray[i] == ')') {
                    // 이미 들어간 괄호와 짝이 맞을경우 둘 다 스택에서 제거
                    if(stack.peek() == '(') {
                        stack.pop();
                    } else {
                        // 짝이 맞지 않음.
                        answer = false;
                        break;
                    }
                }
            }
        }
        // 남아있을 경우 짝이 맞지 않으므로 false
        if(!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
