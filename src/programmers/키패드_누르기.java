package programmers;

public class 키패드_누르기 {

    public static void main(String[] args) {

        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand1 = "right";
        System.out.println("result 1 : " + solution(numbers1, hand1) + " LRLLLRLLRRL");

        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand2 = "left";
        System.out.println("result 2 : " + solution(numbers2, hand2) + " LRLLRRLLLRR");

        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand3 = "right";
        System.out.println("result 3 : " + solution(numbers3, hand3) + " LLRLLRLLRL");
    }

    // 1,4,7은 왼손 & 3,6,9는 오른손
    // 2,5,8,0은 더 가까운 엄지손가락 사용
    // 거리가 같다면 hand 값으로 결정
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int right = 12 ;
        int left = 10;
        for(int number : numbers) {
            // 0일 경우 11로 바꾸어 계산
            if(number == 0) {
                number = 11;
            }
            switch (number % 3) {
                case 0 :
                    // 1, 4, 7
                    right = number;
                    answer += "R";
                    break;
                case 1 :
                    // 3, 6, 9
                    left = number;
                    answer += "L";
                    break;
                case 2 :
                    // 그 외
                    int right_distence = calculateDistance(number, right);
                    int left_distence = calculateDistance(number, left);

                    if (right_distence > left_distence) {
                        left = number;
                        answer += "L";
                    } else if (right_distence < left_distence) {
                        right = number;
                        answer += "R";
                    } else {
                        // 거리가 똑같은 경우 오른손잡이/왼손잡이인지에 따라 위치 달라짐
                        if(hand.equals("left")) {
                            left = number;
                            answer += "L";
                        } else {
                            right = number;
                            answer += "R";
                        }
                    }
                    break;
            }
        }
        return answer;
    }

    // 거리 계산 식
    public static int calculateDistance(int number, int hand) {
        return Math.abs(number - hand) % 3 + Math.abs(number - hand) / 3;
    }
}
