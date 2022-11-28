package programmers.level1;

public class 시저_암호 {

    public static void main(String[] args) {

        System.out.println("result 1 : " + solution("AB", 1));
        System.out.println("result 2 : " + solution("z", 1));
        System.out.println("result 3 : " + solution("a B z", 4));

    }
    public static String solution(String s, int n) {
        String answer = "";
        char[] strArray = s.toCharArray();
        // Character 내장 함수 사용하여 해결
        // 바로 answer에 넣으면 숫자로 추가됨.
        for(char str : strArray) {
            if(Character.isUpperCase(str)) {
                str = (char) ((str - 'A' + n) % 26 + 'A');
            } else if (Character.isLowerCase(str)) {
                str = (char) ((str - 'a' + n) % 26 + 'a');
            }
            answer += str;
        }
        return answer;
    }

    // 접근은 맞은거 같으나 몇개의 테스트 케이스가 틀림.
    public static String solution_61(String s, int n) {
        String answer = "";
        char[] strArray = s.toCharArray();
        for(char str : strArray) {
            if(str == ' ') {
                answer += " ";
            } else {
                if(str + n > 90) {
                    if(str + n > 'z') {
                        str = (char) ('a' + (str - 'z' + n - 1));
                        System.out.println(str);
                    } else {
                        if(str + n > 'Z' && str + n < 'a') {
                            str = (char) ('A' + (str - 'Z' + n - 1));
                            System.out.println(str);
                        } else {
                            str += n;
                        }
                    }
                } else {
                    str += n;
                }
                answer += str;
            }
        }
        return answer;
    }
}
