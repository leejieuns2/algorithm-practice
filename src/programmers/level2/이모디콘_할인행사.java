package programmers.level2;

import org.junit.Assert;
import org.junit.Test;

public class 이모디콘_할인행사 {
    @Test
    public void main() {
        Assert.assertEquals(new int[]{1, 5400},
                solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000}));

        Assert.assertEquals(new int[]{4, 13860},
                solution(new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}},
                        new int[]{1300, 1500, 1600, 4900}));
    }
    // 1번 목표 : 서비스 가입자 증가
    // 2번 목표 : 이모디콘 판매액 MAX
    // users {비율, 가격} : 비율 이상의 할인이 있는 이모디콘 모두 구매, 가격 이상의 구매 시 이모디콘 플러스 구매
    // emoticons : 이모디콘의 가격 배열

    // 할인율 final 변수 선언
    public static final int[] RATE = {90, 80, 70, 60};
    public static int emoticon_plus_cnt;    // 이모디콘 가입자 수
    public static int emoticon_sale_revenue;    // 이모디콘 판매액

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(emoticons, users, 0, new int[emoticons.length]);
        return new int[]{emoticon_plus_cnt, emoticon_sale_revenue};
    }

    public void dfs(int[] emoticons, int[][] users, int current, int[] rates) {
        // 탐색 종료시
        if (current == emoticons.length) {
            updateMaxValue(emoticons, users, rates);
            return;
        }

        for (int rate : RATE) {
            rates[current] = rate;
            dfs(emoticons, users, current + 1, rates);
        }
    }

    private void updateMaxValue(int[] emoticons, int[][] users, int[] rates) {
        int ePlusCnt = 0;
        int revenue = 0;
        for (int[] user : users) {
            int total = 0;
            int rate = user[0];
            int price = user[1];
            for (int i = 0; i < rates.length; i++) {
                if (100 - rates[i] >= rate) {
                    // 할인율을 기준으로 구매액 계산
                    total += emoticons[i] * rates[i] / 100;
                }
                if (total >= price) {
                    // price 기준을 넘으면 이모디콘 플러스 가입
                    ePlusCnt += 1;
                    total = 0;
                    break;
                }
            }
            revenue += total;
        }

        // max 값 판별 후 static 변수에 저장
        if (ePlusCnt > emoticon_plus_cnt) {
            emoticon_plus_cnt = ePlusCnt;
            emoticon_sale_revenue = revenue;
        } else if (ePlusCnt == emoticon_plus_cnt) {
            emoticon_sale_revenue = Math.max(revenue, emoticon_sale_revenue);
        }
    }
}
