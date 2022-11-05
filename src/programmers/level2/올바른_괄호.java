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
                    answer = false;
                    break;
                }
            } else {
                if(sArray[i] == '(') {
                    stack.add('(');
                } else if(sArray[i] == ')') {
                    if(stack.peek() == '(') {
                        stack.pop();
                    } else {
                        answer = false;
                        break;
                    }
                }
            }
        }
        if(!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
