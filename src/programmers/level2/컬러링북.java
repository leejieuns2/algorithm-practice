package programmers.level2;

public class 컬러링북 {
    public static void main(String[] args) {
        int[][] picture = new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[][] picture1 = new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int[][] picture2 = new int[][] {{1, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}};
        int[][] picture3 = new int[][] {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        int[][] picture4 = new int[][] {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 100, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        int[][] picture5 = new int[][] {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        int[][] picture6 = new int[][] {{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0}, {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};

        int[] sol = solution(6, 4, picture);
        System.out.println(sol[0] + " " + sol[1]);
        int[] sol1 = solution(5, 5, picture1);
        System.out.println(sol1[0] + " " + sol1[1]);
        int[] sol2 = solution(5, 5, picture2);
        System.out.println(sol2[0] + " " + sol2[1]);
        int[] sol3 = solution(5, 5, picture3);
        System.out.println(sol3[0] + " " + sol3[1]);
        int[] sol4 = solution(5, 5, picture4);
        System.out.println(sol4[0] + " " + sol4[1]);
        int[] sol5 = solution(6, 4, picture5);
        System.out.println(sol5[0] + " " + sol5[1]);
        int[] sol6 = solution(13, 16, picture6);
        System.out.println(sol6[0] + " " + sol6[1]);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        // 방문 여부를 저장하는 2차원 배열
        boolean[][] visited = new boolean[m][n];

        int[] answer = new int[2];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    int rslt = area(i, j, picture[i][j], visited, picture);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, rslt);
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int area(int m, int n, int color, boolean[][] visited, int[][] picture) {
        if (m < 0 || n < 0 || m >= picture.length || n >= picture[1].length) {
            // index가 범위를 벗어난 경우
            return 0;
        } else if(visited[m][n]) {
            // 이미 방문한 경우
            return 0;
        } else if(picture[m][n] != color) {
            // 영역이 붙어 있지만 원소값이 다른 경우
            return 0;
        } else {
            visited[m][n] = true;
            return 1 + area(m + 1, n, color, visited, picture) // 아래로 이동
                    + area(m - 1, n, color, visited, picture) // 위로 이동
                    + area(m, n - 1, color, visited, picture) // 왼쪽으로 이동
                    + area(m, n + 1, color, visited, picture); // 오른쪽으로 이동
        }
    }
}
