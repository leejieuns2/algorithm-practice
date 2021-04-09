package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class 두_개_뽑아서_더하기 {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        int[] numbers2 = {5,0,2,7};

        int[] rslt1 = solution(numbers);
        System.out.println("rslt1 : ");
        for(int i = 0; i < rslt1.length; i++) {
            System.out.print(rslt1[i] + " ");
        }
        System.out.println();

        int[] rslt2 = solution(numbers2);
        System.out.println("rslt2 : ");
        for(int i = 0; i < rslt2.length; i++) {
            System.out.print(rslt2[i] + " ");
        }
        System.out.println();
    }
    public static int[] solution(int[] numbers) {

        ArrayList<Integer> rslt = new ArrayList<>();

        for(int i = 0; i < numbers.length - 1; i++) {
            // 배열에 중복값이 있는 경우 for문을 돌리지 않고 pass 할 수 있도록 조건문 설정
            if(i != 0 && numbers[i - 1] == numbers[i]) {
                continue;
            } else {
                for (int j = i + 1; j < numbers.length; j++) {
                    int sum = numbers[i] + numbers[j];
                    // 결과 값 중복 여부 체크
                    if (!rslt.contains(sum)) { ;
                        rslt.add(sum);
                    }
                }
            }
        }

        // 결과 값을 오름차순으로 저장해야 하므로
        Collections.sort(rslt);

        // 다시 배열에 저장...^^ 근데 반환값을 바꿔도 된다니 넘 충격
        int[] answer = new int[rslt.size()];
        for(int i = 0; i < rslt.size(); i++) {
            answer[i] = rslt.get(i);
        }

        return answer;
    }
}
