package kr.got.codingtest.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 경우의 수 구하기
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 *
 * 카테고리별 의상이 주어질때 매일 다른 의상을 입을 수 있는 경우의 수를 고르시오.
 * 단, 최소 하나의 의상은 입어야 하며 동일 카테고리의 의상은 중복할 수 없음
 *
 * 의상의 총 수는 1~30개
 * 동일한 의상은 없음
 */
public class 위장 {
    public static void main(String[] args) {
        int result = solution(new String[][]{
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        });

        System.out.println(result);
    }

    public static int solution(String[][] clothes) {
        // 의상의 유형별 가지수 계산
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.get(cloth[1]) != null ? map.get(cloth[1]) + 1 : 1);
        }

        int result = 1;
        for (String k : map.keySet()) {
            // 각 의상 카테고리별로 곱하여 경우의 수 구함
            // +1을 하는 이유는 해당 카테고리의 의상을 안입을 수 있으므로.
            result *= map.get(k) + 1;
        }

        // -1을 하는 이유는 모든 의상을 안입는 경우는 불가능하므로
        return result - 1;
    }
}
