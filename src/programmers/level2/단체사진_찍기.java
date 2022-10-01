package programmers.level2;

import java.util.HashMap;

public class 단체사진_찍기 {

    public static void main(String[] args) {

        System.out.println("result 1 : " + solution(2, new String[]{"N~F=0", "R~T>2"}));
        System.out.println("result 2 : " + solution(2, new String[]{"M~C<2", "C~M>1"}));

    }

    // 다 전역변수로 선언
    public static char[] kakaoFriends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public static HashMap<Character, Integer> kakaoMap = new HashMap<>();
    public static int answer;
    public static int[] output = new int[kakaoFriends.length];
    public static boolean[] visited = new boolean[kakaoFriends.length];

    public static int solution(int n, String[] data) {
        // Hashmap에 초기값 넣기
        for(int i = 0; i < kakaoFriends.length; i++) {
            kakaoMap.put(kakaoFriends[i], i);
        }

        // 전역변수에서 초기화하는 것이 아니라 여기서 0으로 초기화 해야 정확히 계산됨
        answer = 0;
        perm(data, 0);
        return answer;
    }

    // 순열 계산 함수
    static void perm(String[] data, int idx) {
        if (idx == kakaoFriends.length) {
            if(checkPerm(data)) {
                answer++;
            }
        } else {
            for (int i = 0; i < kakaoFriends.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    output[idx] = i;
                    perm(data, idx + 1);
                    visited[i] = false;
                }
            }
        }
    }

    // 간격 체크하는 함수
    static boolean checkPerm(String[] data) {
        for(String dataStr : data) {
            int a = output[kakaoMap.get(dataStr.charAt(0))];
            int b = output[kakaoMap.get(dataStr.charAt(2))];

            char op = dataStr.charAt(3);
            // char --> int 변환
            int rslt = dataStr.charAt(4) - '0' + 1;

            // 조건이 만족되지 않을 경우 false return
            if(op == '=') {
                if(Math.abs(a - b) != rslt) {
                    return false;
                }
            } else if (op == '>') {
                if(Math.abs(a - b) <= rslt) {
                    return false;
                }
            } else {
                if(Math.abs(a - b) >= rslt) {
                    return false;
                }
            }
        }
        return true;
    }
}
