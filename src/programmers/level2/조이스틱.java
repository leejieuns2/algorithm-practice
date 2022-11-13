package programmers.level2;

public class 조이스틱 {

    public static void main(String[] args) {

        String word1 = "JEROEN";
        System.out.println("word1 : " + solution(word1));

        String word2 = "JAN";
        System.out.println("word2 : " + solution(word2));

    }

    public static int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            // 조이스틱 상, 하 이동
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 다음 알파벳이 A인 경우
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endA = i + 1;
                while(endA < name.length() && name.charAt(endA) == 'A')
                    endA++;
                // 오른쪽으로 갔다 다시 왼쪽으로 꺾기
                move = Math.min(move, i * 2 + (name.length() - endA));
                // 왼쪽으로 갔다 다시 오른쪽으로 꺾기
                move = Math.min(move, i + (name.length() - endA) * 2);
            }
        }
        answer += move;
        return answer;
    }
}
