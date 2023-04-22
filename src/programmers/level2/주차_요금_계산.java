package programmers.level2;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.TreeMap;

public class 주차_요금_계산 {
    @Test
    public void main() {
        Assert.assertEquals(Arrays.toString(new int[]{14600, 34400, 5000}),
                Arrays.toString(solution(new int[]{180, 5000, 10, 600},
                        new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
        Assert.assertEquals(Arrays.toString(new int[]{0, 591}),
                Arrays.toString(solution(new int[]{120, 0, 60, 591},
                        new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})));
        Assert.assertEquals(Arrays.toString(new int[]{14841}),
                Arrays.toString(solution(new int[]{1, 461, 1, 10},
                        new String[]{"00:00 1234 IN"})));
    }

    public class FeeTable {
        int initTime;   // 기본 시간
        int initFee;    // 기본 요금
        int unitTime;   // 단위 시간
        int unitFee;    // 단위 요금

        public FeeTable (int initTime, int initFee, int unitTime, int unitFee) {
            this.initTime = initTime;
            this.initFee = initFee;
            this.unitTime = unitTime;
            this.unitFee = unitFee;
        }
    }

    public class Car {
        int hour;           // 진입 시간 (시)
        int minuate;        // 진입 시간 (분)
        int carNumber;      // 차량 번호
        String status;

        public Car (String time, int carNumber, String status) {
            String[] t = time.split(":");
            hour = Integer.parseInt(t[0]);
            minuate = Integer.parseInt(t[1]);
            this.carNumber = carNumber;
            this.status = status;
        }
    }

    public static TreeMap<Integer, Car> carList;
    public static TreeMap<Integer, Integer> rsltList;
    public int[] solution(int[] fees, String[] records) {
        // 주차 요금표 객체 생성
        FeeTable feeTable = new FeeTable(fees[0], fees[1], fees[2], fees[3]);

        carList = new TreeMap<>();
        rsltList = new TreeMap<>();

        for(int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            Car newCar = new Car(record[0], Integer.parseInt(record[1]), record[2]);
            if(carList.containsKey(newCar.carNumber)) {
                Car car = carList.get(newCar.carNumber);
                if (newCar.status.equals("OUT")) {
                    // 들어온 차량이 나갈 경우 정산
                    calculateTotalTime(car, newCar);
                    carList.remove(car.carNumber);
                }
            } else {
                // 처음 들어온 차량이거나 다시 들어온 차량일 경우
                carList.put(newCar.carNumber, newCar);
            }
        }
        // 출차된 내역이 없는 차 totalTime 계산
        if(!carList.isEmpty()) {
            // key array 가져오기
            Object[] keySet = carList.keySet().toArray();
            for (int i = 0; i < keySet.length; i++) {
                Car car = carList.get(keySet[i]);
                Car newCar = new Car("23:59", car.carNumber, "OUT");
                calculateTotalTime(car, newCar);
            }
        }

        int carCount = rsltList.size();
        int[] answer = new int[carCount];
        Object[] keySet = rsltList.keySet().toArray();
        for(int i = 0; i < carCount; i++) {
            answer[i] = calculateFee(feeTable, rsltList.get(keySet[i]));
        }
        return answer;
    }

    public int calculateFee(FeeTable feeTable, int totalTime) {
        int rslt = 0;
        if(totalTime > feeTable.initTime) {
            // 주차 요금 = 기본 요금 + ((누적 주차 시간 - 기본 시간) / 단위 시간)의 절대값 * 단위 요금
            // double로 안 묶어주면 나눗셈 결과값이 소수점 단위까지 나오지 않기 때문에 유의
            double addFee = Math.ceil((double) (totalTime - feeTable.initTime) / feeTable.unitTime);
            rslt = (int) (feeTable.initFee + addFee * feeTable.unitFee);
            System.out.println("addFee : " + addFee);
        } else {
            // 단위 요금보다 작을 경우
            rslt = feeTable.initFee;
        }
        System.out.println(totalTime + " rslt : " + rslt);
        return rslt;
    }

    // 누적 주차 시간 구하기
    public void calculateTotalTime(Car car, Car newCar) {
        int totalTime = 0;
        if(newCar.minuate >= car.minuate) {
            totalTime = (newCar.hour - car.hour) * 60 + (newCar.minuate - car.minuate);
        } else {
            totalTime = (newCar.hour - (car.hour + 1)) * 60 + (newCar.minuate + (60 - car.minuate));
        }
        System.out.println(car.carNumber + " totalTime : " + totalTime);
        if(isFirstVisited(car)) {
            // 새롭게 결과 리스트에 추가
            rsltList.put(car.carNumber, totalTime);
        } else {
            // 기존 값과 최종 시간 더하기
            totalTime += rsltList.get(car.carNumber);
            rsltList.replace(car.carNumber, totalTime);
        }
        System.out.println(car.carNumber + " totalTime : " + totalTime);
    }

    public boolean isFirstVisited(Car car) {
        if(rsltList.containsKey(car.carNumber)) {
            return false;
        }
        return true;
    }
}
