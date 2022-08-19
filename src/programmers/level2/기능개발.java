package programmers.level2;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 프로그래머스 - 스텍/큐
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * */

public class 기능개발 {

	public static void main(String[] args) {
		
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		int[] answer = solution(progresses, speeds);
		
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println();
	}
	
	public static int countDay(int remain, int speeds) {
		if(remain % speeds != 0) {
			return (remain / speeds) + 1;
		} else {
			return remain / speeds;
		}
	}

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] day = new int[progresses.length]; 
        // 작업 목표 달성까지 걸리는 일수를 계산한 것들을 저장 
        ArrayList<Integer> array = new ArrayList<Integer>();
        // answer에 넣을 값들을 임시 저장하는 리스트 
        
        for(int i = 0; i < progresses.length; i++) {
        	// 남은 작업 진도 계산 
        	int remain = 100 - progresses[i];
        	// 작업 목표 달성까지 걸리는 일수 계산 
        	day[i] = countDay(remain, speeds[i]);
        }
                
        int cnt = 1;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < progresses.length; i++) {
        	if(stack.size() == 0) {
        		// 현재 진행중인 작업이 없다면, 
        		stack.add(day[i]);
        	} else {
        		// 현재 진행중인 작업이 있다면,
        		if(day[i] <= stack.peek()) {
        			// 다음 작업이 먼저 끝날 경우, 
        			cnt++;
        		} else {
        			// 다음 작업이 늦게 끝날 경우, 
        			array.add(cnt); // 그 전의 작업이 배포될 때 같이 배포되는 작업의 수 저장.
        			cnt = 1;
        			stack.pop();
        			stack.add(day[i]);
        			// 작업중이지 않다는 의미로 스텍에서 뽑아내기.
        		}
        	}
        }
        
        // 마지막 작업 리스트에 넣어주기 
        if(stack.size() != 0) {
        	array.add(cnt);
        }
        
        answer = new int[array.size()];
        for(int i = 0; i < array.size(); i++) {
        	answer[i] = array.get(i);
        }
        
        return answer;
    }
}
