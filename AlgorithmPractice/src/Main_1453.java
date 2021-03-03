import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 1453. 피시방 알바
 * https://www.acmicpc.net/problem/1453
 * */

public class Main_1453 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 손님의 수 N
        int N = Integer.parseInt(br.readLine());

        // 현재 피시방의 착석 상황을 저장하는 HashMap
        HashMap<Integer, Boolean> customer = new HashMap<Integer, Boolean>();

        // 거절당한 손님의 수를 저장하는 변수
        int reject = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreElements()) {
            int num = Integer.parseInt(st.nextToken());

            if(customer.getOrDefault(num, false)) {
                // 만약 값이 true일 경우 이미 자리가 채워져 있는 것이므로 거절
                reject++;
            } else{
                // 착석 가능. HashMap value를 true로 변경
                customer.put(num, true);
            }
        }

        // 결과 출력
        System.out.println(reject);
    }
}
