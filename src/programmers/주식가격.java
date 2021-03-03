package programmers;

import java.util.Stack;

/*
 * 프로그래머스 - 스텍/큐
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 * */

public class 주식가격 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] prices = {1, 2, 3, 2, 3};
		int[] answer = solution(prices);
		
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println();
	}
	
    public static int[] solution(int[] prices) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<Integer>();
        
        int min = prices.length - 1;
        System.out.println(prices.length);
        int num = 0;
        for(int i = prices.length - 1; i >= 0; i--) {
        	if(min == i) {
        	   stack.push(0);
        	   System.out.println("if");
        	   // 마지막 값은 항상 유지되는 시간이 0초이기 때문에 미리 넣어주기.
        	} else if(prices[min] > prices[i]) {
        		// 저장되어 있는 최솟값보다 작은 경우 
        		System.out.println("min, i : " + min + " " + i);
        		num = (min - i) + 1;
        		stack.push(num);
        		min = i; // 최솟값 변경
        		System.out.println("if 1 : " + num);
        	} else if (prices[min] == prices[i]) {
        		// 저장되어 있는 최솟값과 비교값이 같은 경우
        		num = (min - i) + 1;
        		stack.push(num);
        		System.out.println("if 2");
        	} else {
        		// 최솟값보다 비교값이 더 큰 경우 
        		stack.push(1);
        		System.out.println("if 3");
        	}
        } 
        System.out.println(stack.toString());
        // 결과값 index에 저장하기.
        answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
        	answer[i] = stack.pop();
        }
        
        return answer;
    }
    // answer : [4, 3, 1, 1, 0]

}
