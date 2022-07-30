package programmers;

import java.util.Arrays;

public class 로또의_최고_순위와_최저_순위 {

    public static void main(String[] args) {

        int[] lottos1 = {44, 1, 0, 0, 31, 25};
        int[] win_nums1 = {31, 10, 45, 1, 6, 19};
        System.out.println("result 1 : " + Arrays.toString(solution(lottos1, win_nums1)));

        int[] lottos2 = {0, 0, 0, 0, 0, 0};
        int[] win_nums2 = {38, 19, 20, 40, 15, 25};
        System.out.println("result 2 : " + Arrays.toString(solution(lottos2, win_nums2)));

        int[] lottos3 = {45, 4, 35, 20, 3, 9};
        int[] win_nums3 = {20, 9, 3, 45, 4, 35};
        System.out.println("result 3 : " + Arrays.toString(solution(lottos3, win_nums3)));
    }

    // 알아볼 수 없는 번호를 0으로 표기, 로또에 당첨될 최고 순위와 최저 순위를 배열로 출력
    // 매개변수로는 민수가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums
    // 알아볼 수 없는 번호가 모두 당첨 번호에 존재할 경우 / 둘 다 존재하지 않을 경우를 가정해 코드 작성
    public static int[] solution(int[] lottos, int[] win_nums) {

        // 맞춘 개수 세기
        int correct_num = 0;

        // 0의 개수를 샐 추가 변수
        int zero_count = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zero_count++;
                continue;
            } else {
                for(int win_num: win_nums) {
                    if(lotto == win_num) {
                        correct_num++;
                        break;
                    }
                }
            }
        }
        int max_rank = rank(correct_num + zero_count);
        int min_rank = rank(correct_num);

        return new int[]{max_rank, min_rank};
    }

    // 등수 계산 함수
    public static int rank(int num) {
        switch(num){
            case 0: return 6;
            case 1: return 6;
            case 2: return 5;
            case 3: return 4;
            case 4: return 3;
            case 5: return 2;
            case 6: return 1;
            default: return 0;
        }
    }

    // 정답, but 위의 코드가 더 가독성 좋음
    public static int[] solution_2(int[] lottos, int[] win_nums) {

        // 맞춘 개수 세기
        int correct_num = 0;

        // 0의 개수를 샐 추가 변수
        int zero_count = 0;

        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zero_count++;
                continue;
            } else {
                for(int j = 0; j < 6; j++) {
                    if(lottos[i] == win_nums[j]) {
                        correct_num++;
                        break;
                    }
                }
            }
        }
        int max_rank = rank(correct_num + zero_count);
        int min_rank = rank(correct_num);


        return new int[]{max_rank, min_rank};
    }

    // 왜 93점.....???????????
    public static int[] solution_1(int[] lottos, int[] win_nums) {

        // 최대 & 최소 등수 저장할 변수
        int min_rank = 7;
        int max_rank = 7;

        // 0의 개수를 샐 추가 변수
        int zero_count = 0;

        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zero_count += 1;
                continue;
            } else {
                for(int j = 0; j < 6; j++) {
                    if(lottos[i] == win_nums[j]) {
                        min_rank -= 1;
                        max_rank -= 1;
                        break;
                    }
                }
            }
        }
        if (zero_count == 6) {
            max_rank = 1;
            min_rank = 6;
        } else if (zero_count == 0 && min_rank != 1 && max_rank != 1){
            min_rank -= 1;
            max_rank -= 1;
        } else {
            max_rank -= zero_count;
        }

        return new int[]{max_rank, min_rank};
    }
}
