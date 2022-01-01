package kr.got.codingtest.arrays;

import java.util.Arrays;

/**
 * N개의 정수로 구성된 배열의 각 요소는 동일한 값에 해당하는 값들이 짝수개있고,
 * 하나의 요소만 홀수개가되어 짝을 이룰 수 없음
 * 이떄 짝을 이룰 수 없는 요소의 값을 리턴하라.
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 * [9, 3, 9, 3, 9, 7, 9]가 주어질 경우 9는 4개, 3은 2개, 7은 1개로 7을 리턴.
 * 제약사항: N은 1~1,000,000 범위 내의 홀수 정수, 배열 A의 각 요소는 1~ 1,000,000,000 범위 내의 정수
 */
public class OddOccurrenceInArray {
    public static void main(String[] args) {
        int result = solution(new int[]{9, 3, 9, 3, 7, 9});
        System.out.println(result);
    }

    /**
     * 내 풀이
     */
    public static int solution(int[] values) {
        // 배열을 정렬
        Arrays.sort(values);

        int i = 0;      // 마지막 요소값
        int cnt = 0;    // 해당 요소의 카운트
        for (int v : values) {
            // 마지막 요소와 값이 달라지면서, 마지막 요소의 카운트가 홀수일때 종료
            if (i > 0 && i != v && cnt % 2 == 1) {
                break;
            }
            cnt++;
            i = v;
        }
        return i;
    }
}
