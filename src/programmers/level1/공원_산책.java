package programmers.level1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class 공원_산책 {
    @Test
    public void main() {
        Assert.assertEquals(Arrays.toString(new int[]{2, 1}),
                Arrays.toString(solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
        Assert.assertEquals(Arrays.toString(new int[]{0, 1}),
                Arrays.toString(solution(new String[]{"SOO", "OXX", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
        Assert.assertEquals(Arrays.toString(new int[]{0, 0}),
                Arrays.toString(solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
    }
    public static String[][] parkMap;
    public static int pX, pY;   // 공원 직사각형 가로세로 길이
    public static int rX, rY;   // 정답 좌표
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};

        pX = park.length;
        pY = park[0].length();
        parkMap = new String[pX][pY]; // 공원은 직사각형 모양이므로
        for(int i = 0; i < pX; i++) {
            for(int j = 0; j < pY; j++) {
                parkMap[i][j] = String.valueOf(park[i].charAt(j));
                if(parkMap[i][j].equals("S")) {
                    // 시작 좌표 저장
                    rX = i;
                    rY = j;
                }
            }
        }

        for(int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            String op = route[0];
            int n = Integer.parseInt(route[1]);
            moveDog(op, n);
            System.out.println(rX + " " + rY);
        }

        return new int[]{rX, rY};
    }
    // 로봇강아지 이동
    public void moveDog(String op, int n) {
        int tmpX = rX;
        int tmpY = rY;
        switch (op) {
            case "N":
                // 북쪽
                for(int i = 0; i < n; i++) {
                    if(!isRightWay(tmpX - 1, tmpY)) {
                        break;
                    }
                    tmpX--;
                }
                if(tmpX == rX - n) {
                    rX -= n;
                }
                break;
            case "S":
                // 남쪽
                for(int i = 0; i < n; i++) {
                    if(!isRightWay(tmpX + 1, tmpY)) {
                        break;
                    }
                    tmpX++;
                }
                if(tmpX == rX + n) {
                    rX += n;
                }
                break;
            case "W":
                // 서쪽
                for(int i = 0; i < n; i++) {
                    if(!isRightWay(tmpX, tmpY - 1)) {
                        break;
                    }
                    tmpY--;
                }
                if(tmpY == rY - n) {
                    rY -= n;
                }
                break;
            case "E":
                // 동쪽
                for(int i = 0; i < n; i++) {
                    if(!isRightWay(tmpX, tmpY + 1)) {
                        break;
                    }
                    tmpY++;
                }
                if(tmpY == rY + n) {
                    rY += n;
                }
                break;
            default:
                break;
        }
    }
    public boolean isRightWay(int x, int y) {
        // 범위 넘어서는지 체크
        if(x < 0 || y < 0 || x >= pX || y >= pY) {
            return false;
        }
        // 장애물인지 체크
        if(parkMap[x][y].equals("X")) {
            return false;
        }
        return true;
    }
}
