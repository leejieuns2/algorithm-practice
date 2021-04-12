package programmers;

public class 소수_만들기 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 7, 6, 4};

        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
    }
    public static int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    // 숫자 세개 더하기
                    int sum = nums[i] + nums[j] + nums[k];

                    // sum 값 소수 판별
                    if(isPrime(sum)) {
                        System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    // 소수 판별 메소드
    public static boolean isPrime(int number) {
        // 0 과 1
        if(number == 0 || number == 1) {
            return false;
        }

        // 2
        if(number == 2) {
            return true;
        }

        // 그 외 숫자
        // 제곱근 함수 : Math.sqrt()
        for(int i = 2; i <= Math.sqrt(number); i++) {
            // 소수가 아닐경우
            if(number % i == 0) {
                return false;
            }
        }

        // 반복문에서 벗어난 경우 약수가 자기 자신과 1밖에 없는 경우이므로 true 반환.
        return true;
    }
}
