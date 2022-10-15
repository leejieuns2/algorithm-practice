package programmers.level1;

public class 다트_게임 {

    public static void main(String[] args) {
        String word1 = "1S2D*3T";
        System.out.println("word1 : " + solution(word1));

        String word2 = "1D2S#10S";
        System.out.println("word2 : " + solution(word2));

        String word3 = "1S*2T*3S";
        System.out.println("word3 : " + solution(word3));

        String word4 = "1D#2S*3S";
        System.out.println("word4 : " + solution(word4));

        String word5 = "1T2D3D#";
        System.out.println("word5 : " + solution(word5));

        String word6 = "1D2S3T*";
        System.out.println("word6 : " + solution(word6));

    }

    public static int solution(String dartResult) {
        // 항상 문자열은 3세트로 구성
        int answer = 0;
        int answerValue[] = new int[3];
        int idx = 0, intCnt = 0;

        for(int i = 0; i < dartResult.length(); i++) {
            char dartChar = dartResult.charAt(i);
            int dartInt = Character.getNumericValue(dartChar);

            if(dartInt >= 0 && dartInt <= 10) {
                // score
                if(dartInt == 1) {
                    if(Character.getNumericValue(dartResult.charAt(i+1)) == 0) {
                        dartInt = 10;
                        i++;
                    }
                }

                answerValue[idx] = dartInt;
                intCnt++;
            } else {
                // 보너스 점수 or 옵션
                switch(dartChar) {
                    case 'S':
                        // Single
                        answerValue[idx] = (int) Math.pow(answerValue[idx], 1);
                        idx++;
                        break;
                    case 'D':
                        // Double
                        answerValue[idx] = (int) Math.pow(answerValue[idx], 2);
                        idx++;
                        break;
                    case 'T':
                        // Triple
                        answerValue[idx] = (int) Math.pow(answerValue[idx], 3);
                        idx++;
                        break;
                    case '*':
                        // 스타상
                        idx = idx - 2 < 0 ? 0 : idx - 2;
                        while (idx < intCnt) {
                            answerValue[idx] = answerValue[idx] * 2;
                            idx++;
                        }
                        break;
                    case '#':
                        // 아차상
                        answerValue[idx - 1] = answerValue[idx - 1] * (-1);
                        break;
                }
            }
        }

        for (int value : answerValue) {
            answer += value;
        }

        return answer;
    }
}
