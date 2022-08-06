package programmers;

import java.util.ArrayList;
import java.util.Stack;

public class 크레인_인형뽑기_게임 {

    public static void main(String[] args) {

        int[][] board1= {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves1 = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println("result 1 : " + solution(board1, moves1));

    }

    // 게임 사용자는 멈춘 위치에서 가장 위에 있는 인형을 집어올림.
    // 같은 인형을 집었을 시 같은 인형 둘 다 삭제
    // 인형이 집어지지 않을 경우 없음. 인형이 없는 곳으로 작동시키는 경우 아무 일도 일어나지 않음.
    // 터트려져 사라진 인형의 개수 return
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 2차원 배열의 크기는 N * N 이므로.
        int N = board.length;

        //        1 [3, 4]
        //        2 [5, 2, 2]
        //        3 [1, 4, 5, 1]
        //        4 [3, 4]
        //        5 [1, 2, 1, 3]
        ArrayList<Stack<Integer>> board_list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            // 초기화
            board_list.add(new Stack());
            for (int j = N - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    board_list.get(i).push(board[j][i]);
                }
            }
            System.out.println(i+1 + " " + board_list.get(i).toString());
        }

        // 현재 인형이 담겨있는 Stack;
        Stack<Integer> pick_doll = new Stack<Integer>();
        for (int move : moves) {
            if(!board_list.get(move - 1).isEmpty()) {
                int pop_doll = board_list.get(move - 1).pop();
                if (!pick_doll.isEmpty() && pop_doll == pick_doll.peek()) {
                    // 넣어진 인형 빼기
                    pick_doll.pop();
                    // 터진 인형의 개수 더하기
                    answer += 2;
                } else {
                    pick_doll.push(pop_doll);
                }
                System.out.println("pick_doll : " + pick_doll.toString());
                System.out.println(answer);
            }
        }
        return answer;
    }

}
