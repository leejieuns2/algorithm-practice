package programmers.level3;

import org.junit.Assert;
import org.junit.Test;

public class 단어_변환 {

    @Test
    public void main() {
        Assert.assertEquals(4,
                solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        Assert.assertEquals(0,
                solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
    static int answer;  // 반환 값 저장
    static boolean[] visited;   // 방문 여부 저장
    public int solution(String begin, String target, String[] words) {
        // 최대 개수는 전체 words의 길이를 초과할 수 없으므로
        answer = words.length + 1;
        visited = new boolean[words.length];
        dfs(begin, target, 0, words);
        return (answer == words.length + 1)? 0 : answer;
    }

    // 다른 char 개수 세기
    public boolean compareStr(String begin, String word) {
        int cnt = 0;
        for(int i = 0; i < begin.length(); i++) {
            if(begin.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    public void dfs(String begin, String target, int cnt, String[] words) {
        // 만약 target과 글자가 일치할 경우 바로 반환
        if (begin.equals(target)) {
            answer = Math.min(cnt, answer);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            // 다른 글자가 1개인지 판별 & 이미 바꾼 글자인지 판별
            if (compareStr(begin, words[i]) && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, cnt + 1, words);
                visited[i] = false;
            }
        }
    }
}
