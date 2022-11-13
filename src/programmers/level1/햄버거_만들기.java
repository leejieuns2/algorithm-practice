package programmers.level1;

import java.util.*;

public class 햄버거_만들기 {

    public static void main(String[] args) {

        int[] a1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println("result 1 : " + solution(a1));

        int[] a2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        System.out.println("result 2 : " + solution(a2));

        int[] a3 = {1, 1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1};
        System.out.println("result 3 : " + solution(a3));

    }
    public static int solution(int[] ingredient) {
        Stack<Integer> ingredients = new Stack<>();
        int count_Burger = 0;
        for (int num = 0; num < ingredient.length; num++) {
            ingredients.push(ingredient[num]);
            int size = ingredients.size();
            if (size > 3 && ingredients.peek() == 1
                    && ingredients.get(size-2) == 3
                    && ingredients.get(size-3) == 2
                    && ingredients.get(size-4) == 1) {
                packaging_Burger(ingredients);
                count_Burger++;
            }
        }
        return count_Burger;
    }

    private static void packaging_Burger(Stack<Integer> ingredients) {
        ingredients.pop();
        ingredients.pop();
        ingredients.pop();
        ingredients.pop();
    }

    // 41.2 점
    public static int solution_41(int[] ingredient) {
        int answer = 0;
        int[] hambuger = {1, 2, 3, 1};
        Stack<Integer> ing = new Stack<>();

        for(int i = 0; i < ingredient.length; i++) {
            ing.add(ingredient[i]);
            System.out.println("ing : " + ing.toString());
            int size = ing.size();
            if (size >= 4) {
                Stack<Integer> tmp = ing;
                int h_idx;
                for(h_idx = hambuger.length - 1; h_idx >= 0; h_idx--) {
                    if(!(tmp.peek() == hambuger[h_idx])) {
                        break;
                    }
                    tmp.pop();
                    System.out.println("tmp : " + tmp.toString());
                }
                System.out.println("h_idx : " + h_idx);
                if (h_idx < 0) {
                    answer++;
                    ing = tmp;
                    System.out.println(answer);
                }
            }
        }
        return answer;
    }
}
