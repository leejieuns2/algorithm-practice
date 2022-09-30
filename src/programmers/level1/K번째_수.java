package programmers.level1;

import java.util.*;

public class K번째_수 {

    public static void main(String[] args) {

        int[][] command1 = {{2,5,3}, {4,4,1}, {1,7,3}};
        int[] array1 = {1, 5, 2, 6, 3, 7, 4};
        System.out.println("result 1 : " + solution(array1, command1).toString());

    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // copyOfRange (배열 index로 자르는 변수. subString() 과 비슷)
        for(int i = 0; i < commands.length; i++) {
            int[] subArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(subArray);
            answer[i]= subArray[commands[i][2] - 1];
            System.out.println(answer[i]);
        }

        return answer;
    }
}
