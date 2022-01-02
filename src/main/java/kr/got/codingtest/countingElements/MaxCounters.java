package kr.got.codingtest.countingElements;

import java.util.Arrays;

/**
 * 주어진 배열과 임의의 정수로 결과 배열을 생성하여 리턴하라.
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 *
 * 임의의 정수 N은 결과 배열의 크기값이고,
 * 반환할 결과 배열 result은
 * M개의 정수로 구성된 주어진 배열 A의 각 요소별 값을 카운팅한 수를 저장하기위한 배열임.
 *
 * 카운팅하기위한 조건은
 *  1. 배열의 요소 X가 '1 <= X <= N'인 경우 결과배열의 해당 위치의 값을 1 증가
 *  2. 'X = N +1'이면 X가 최대 카운터가 되며 나머지 결과배열의 모든 요소를 X로 갱신.
 *
 *  예를들어 N이 5이고, A[] = new int[] {3, 4, 4, 6, 1, 4, 4}; 배열이 주어질때,
 *  결과 배열 result[]는 다음과 같이 변화함.
 *      result[] = new int[5];  // {0, 0, 0, 0, 0}
 *      A[0] = 3 이므로 3번째 값 1 증가 -> {0, 0, 1, 0, 0}
 *      A[1] = 4 이므로 4번쨰 값 1 증가 -> {0, 0, 1, 1, 0}
 *      A[2] = 4 이므로 4번쨰 값 1 증가 -> {0, 0, 1, 2, 0}
 *      A[3] = 6 이므로 조건 2에 충족(N+1)하게되어 모든값을 결과배열 요소중 최대값인 2 (result[3]값)으로 갱신
 *       -> {2, 2, 2, 2, 2}
 *      A[4] = 1 이므로 1번째 값 1 증가 -> {3, 2, 2, 2, 2}
 *      A[5] = 4 이므로 4번째 값 1 증가 -> {3, 2, 2, 3, 2}
 *      A[6] = 4 이므로 4번째 값 1 증가 -> {3, 2, 2, 4, 2}
 *  최종 반환할 결과 배열 result[]는 {3, 2, 2, 4, 2}가 됨.
 *
 *  제약사항:
 *      - 주어진 정수 N과 M은 1 ~ 100,000 범위 내의 정수
 *      - 배열 A의 각 요소는 '1 ~ N + 1' 범위 내의 정수
 */
public class MaxCounters {
    public static void main(String[] args) {
        int[] result = solutionBetter(5, new int[]{3, 4, 4, 6, 1, 4, 4});

        System.out.println(result);
    }

    /**
     * 1차 솔루션
     *  - O(NM) ? 복잡도로 80% 성공
     */
    public static int[] solution(int n, int[] values) {
        int[] result = new int[n];

        // 마지막 최대 카운팅값(요소의 값이 N+1보다 클때 갱신하기위함)
        int max = 0;
        for (int v : values) {
            // 요소의 값이 n+1보다 작을 경우 해당하는 결과배열 요소만 카운팅.
            if (v < n + 1) {
                result[v - 1]++;

                // 카운팅한 후 해당 값이 max인지 확인 후 갱신
                max = Math.max(max, result[v - 1]);
            } else {

                // 요소의 값이 n+1과 같을 경우 모든 결과배열 요소를 max값으로 갱신.
                Arrays.fill(result, max);
            }
        }
        return result;
    }

    /**
     * 수정된 최종 솔루션
     *  - O(N + M) 복잡도로 100% 성공
     */
    public static int[] solutionBetter(int n, int[] values) {
        int[] result = new int[n];

        int max = 0;
        int max2 = 0;
        for (int v : values) {
            if (v < n + 1) {
                result[v - 1] = Math.max(max2, result[v - 1]);
                result[v - 1]++;
                max = Math.max(max, result[v - 1]);
            } else {
                max2 = Math.max(max2, max);
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = Math.max(max2, result[i]);
        }
        return result;
    }
}
