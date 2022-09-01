package programmers.level1;

public class 최소직사각형 {

    public static void main(String[] args) {

        int[][] size1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println("result 1 : " + solution(size1));

        int[][] size2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println("result 1 : " + solution(size2));

        int[][] size3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        System.out.println("result 1 : " + solution(size3));

    }

    // 가장 작은 크기의 지갑으로 모든 명함을 수납할 수 있도록 하기
    // 명함을 눕혀서 수납하는 경우의 수도 고려할 것.
    // 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어짐.
    // 가로 & 세로에 갇혀서 생각하기 보다는 한 배열에 있는 두 수중 큰 것들만 비교 + 작은 것들만 비교 한다고 생각하기.
    // 큰 것들만 비교해서 제일 큰게 가로, 작은 것들만 비교해서 제일 큰게 세로. 둘을 곱한게 return 값.

    public static int solution(int[][] sizes) {
        int w = 0, h = 0;
        for(int[] size : sizes) {
            w = Math.max(w, Math.max(size[0], size[1]));
            h = Math.max(h, Math.min(size[0], size[1]));
        }
        int answer = w * h;
        return answer;
    }
}
