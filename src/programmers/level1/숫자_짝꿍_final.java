package programmers.level1;

public class 숫자_짝꿍_final {

    public static void main(String[] args) {

        String x1 = "100";
        String y1 = "2345";
        System.out.println("word1 : " + solution(x1, y1));

        String x2 = "100";
        String y2 = "203045";
        System.out.println("word2 : " + solution(x2, y2));

        String x3 = "100";
        String y3 = "123450";
        System.out.println("word3 : " + solution(x3, y3));

        String x4 = "12321";
        String y4 = "42531";
        System.out.println("word4 : " + solution(x4, y4));

        String x5 = "5525";
        String y5 = "1255";
        System.out.println("word5 : " + solution(x5, y5));

    }

    public static String solution(String X, String Y) {
        String answer = "";

        int[] xArr = new int[10];
        int[] yArr = new int[10];

        // 반복되는 부분 빼는 것은 효율성에 크게 도움되진 않는듯.
        if (X.length() >= Y.length()) {
            addArray(Y, yArr, X, xArr);
        } else {
            addArray(X, xArr, Y, yArr);
        }

        for(int i = 9; i >= 0; i--) {
            if(xArr[i] >= 1 && yArr[i] >= 1) {
                // 핵심은 아래 문장. while문이나 for문이 아닌 repeat 함수를 써야 복잡도가 감소하는듯.
                // 그리고 둘의 차이를 구해서 그 수만큼 반복하도록.
                int min = Math.min(xArr[i], yArr[i]);
                if(min > 0) {
                    answer += String.valueOf(i).repeat(min);
                }
            }
        }

        // 짝지을 숫자가 없는 경우, 0이 두개 이상인 경우 판별해서 return 해주기
        if(answer.equals("")) {
            return "-1";
        } else if (answer.startsWith("0")) {
            return "0";
        } else {
            return answer;
        }
    }
    public static void addArray(String small, int[] smallArray, String big, int[] bigArray) {
        for(int i = 0; i < big.length(); i++) {
            bigArray[big.charAt(i) - '0']++;
            if(i < small.length()) {
                smallArray[small.charAt(i) - '0']++;
            }
        }
    }
}
