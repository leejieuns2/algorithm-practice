package programmers;

public class 순위_검색 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        int[] rslt = solution(info, query);

        for(int i = 0; i < rslt.length; i++) {
            System.out.println(rslt[i] + " ");
        }
        System.out.println();
    }
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // info에서 지원 정보 추출
        for(int i = 0; i < info.length; i++) {
            String[] info_detail = info[i].split(" ");

            System.out.println(info_detail[0] + " " + info_detail[1] + " " + info_detail[2] + " " + info_detail[3] + " " + info_detail[4]);
            // query에서 조건 정보 추출 및 검사
            for(int j = 0; j < query.length; j++) {
                String[] query_detail = query[j].split(" and | ");
                System.out.println(query_detail[0] + " " + query_detail[1] + " " + query_detail[2] + " " + query_detail[3] + " " + query_detail[4]);

                int info_score = Integer.parseInt(info_detail[Infomation.SCORE.index]);
                int query_score = Integer.parseInt(query_detail[Infomation.SCORE.index]);
                if(!isOverScore(info_score, query_score)) {
                    continue;
                } else {
                    if (info_detail[Infomation.LANGUAGE.index].equals(query_detail[Infomation.LANGUAGE.index])
                            || query_detail[Infomation.LANGUAGE.index].equals("-")) {
                        if (info_detail[Infomation.JOB.index].equals(query_detail[Infomation.JOB.index])
                                || query_detail[Infomation.JOB.index].equals("-")) {
                            if (info_detail[Infomation.CAREER.index].equals(query_detail[Infomation.CAREER.index])
                                    || query_detail[Infomation.CAREER.index].equals("-")) {
                                if (info_detail[Infomation.FOOD.index].equals(query_detail[Infomation.FOOD.index])
                                        || query_detail[Infomation.FOOD.index].equals("-")) {
                                    answer[j] ++;

                                }
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    // 점수가 기준에 부합하는지 판별하는 메소드
    static boolean isOverScore(int info_score, int query_score) {
        if(info_score >= query_score) {
            return true;
        }
        return false;
    }

    enum Infomation {

        LANGUAGE(0),    // 개발 언어
        JOB(1),         // 직군
        CAREER(2),      // 경력
        FOOD(3),        // 소울 푸드
        SCORE(4);       // 코딩테스트 점수

        private int index;

        Infomation(int index) {
            this.index = index;
        }
    }
}
