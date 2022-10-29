package programmers.level1;

public class 숫자_짝꿍_73 {

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
        String[] xArr = new String[10];
        String[] yArr = new String[10];

        for(int i = 0; i < 10; i++) {
            xArr[i] = "";
        }

        for(int i = 0; i < 10; i++) {
            yArr[i] = "";
        }

        for(int i = 0; i < X.length(); i++) {
            xArr[X.charAt(i) - '0'] += X.charAt(i) - '0';
        }

        for(int i = 0; i < Y.length(); i++) {
            yArr[Y.charAt(i) - '0'] += Y.charAt(i) - '0';
        }

        for(int i = 9; i >= 0; i--) {
            if(xArr[i] != null && yArr[i] != null) {
                if (xArr[i].length() >= 1 && yArr[i].length() >= 1) {
                    int min = Math.min(xArr[i].length(), yArr[i].length());
                    answer += yArr[i].substring(0, min);
                }
            }
        }

        if(answer.equals("")) {
            return "-1";
        } else if (answer.startsWith("0")) {
            return "0";
        } else {
            return answer;
        }
    }

    public String solution_73(String X, String Y) {
        String answer = "";
        int[] xArr = new int[10];
        int[] yArr = new int[10];

        for(int i = 0; i < X.length(); i++) {
            xArr[X.charAt(i) - '0']++;
        }

        for(int i = 0; i < Y.length(); i++) {
            yArr[Y.charAt(i) - '0']++;
        }

        for(int i = 9; i >= 0; i--) {
            while (xArr[i] >= 1 && yArr[i] >= 1) {
                xArr[i]--;
                yArr[i]--;
                answer += i;
            }
        }

        if(answer.equals("")) {
            return "-1";
        } else if (answer.startsWith("0")) {
            return "0";
        } else {
            return answer;
        }
    }

    public static String solution_47(String X, String Y) {
        String answer = "";
        int[] xArr = new int[10];
        int[] yArr = new int[10];

        for(int i = 0; i < X.length(); i++) {
            xArr[X.charAt(i) - '0']++;
        }

        for(int i = 0; i < Y.length(); i++) {
            yArr[Y.charAt(i) - '0']++;
        }

        for(int i = 9; i >= 0; i--) {
            if(xArr[i] > 0 && yArr[i] > 0) {
                int min = Math.min(xArr[i],yArr[i]);
                answer += i;
                answer = (i != 0) ? answer.repeat(min) : answer;
            }
        }
        return (answer.equals("")) ? "-1" : answer;
    }
}
