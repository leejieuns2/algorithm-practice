package programmers.level2;

public class 멀쩡한_사각형 {

    public static void main(String[] args) {
        System.out.println("result 1 : " + solution(8, 12));
    }

    public static long solution(long w, long h) {
        long gcdValue = (w > h)? GCD(w, h) : GCD(h, w);
        long answer = (w * h) - (w + h - gcdValue);

        return answer;
    }

    // 유클리드 호제법을 이용해 풀이....^^?
    public static long GCD(long big, long small) {
        if(small == 0)
            return big;
        else return GCD(small,big % small);
    }
}
