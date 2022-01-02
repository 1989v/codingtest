package kr.got.codingtest.countingElements;

import java.util.HashSet;
import java.util.Set;

/**
 * 임의의 정수 K와, 1~K까지의 정수로 구성된 정수형 배열 A가 주어질때,
 * A배열의 각 요소들이 1~K까지 모두 나오는 위치의 인덱스를 리턴하라.
 * https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 *
 * K가 5이고, A가 {1, 3, 1, 4, 2, 3, 5, 4} 일때
 * 1~5까지 모든 값이 나오는 배열 A의 인덱스는 A[6]이므로 6을 리턴.
 */
public class FrogRiverOne {
    public static void main(String[] args) {
        int result = solution(new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 5);

        System.out.println(result);
    }

    public static int solution(int[] values, int target) {
        int result = -1;
        // Set 자료구조의 특징(중복값 불허, 순서 없음)상 각 요소를 Set에 집어넣고,
        // Set의 개수가 target과 같아질때의 인덱스를 반환하면 됨.
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < values.length; i++) {
            set.add(values[i]);
            if (set.size() == target) {
                result = i;
                break;
            }
        }
        return result;
    }
}
