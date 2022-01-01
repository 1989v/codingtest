package kr.got.codingtest.timeComplexity;

/**
 * 주어진 순열에서 누락된 요소 찾기
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 *
 * N개의 서로 다른 정수 배열에서 각 요소는 '1~(N+1)' 범위가 될 수 있을때 누락된 값을 리턴
 * {2, 4, 1, 5}배열은 4개 요소이므로 1~5의 값 중 3가 누락되어있음
 * 제약사항: N(개수)은 0~100,000 / 각 요소는 모두 다름 / 1~(N+1) 범위내 정수
 */
public class PermMissingElem {
    public static void main(String[] args) {
        int result = solution(new int[]{2, 3, 1, 5});

        System.out.println(result);
    }

    public static int solution(int[] values) {
        /**
         * 아이디어: 1부터 (N+1)까지 모든 수를 더하고, 주어진 값을 빼면 됨.
         * 단, 배열의 최대값이 N+1이 아닐 수 있으므로(제일 큰 값이 빠져있을 수 있으므로)
         * 배열최대값과 values.length와 크기비교 필요.
         */
        long total = 0; // 100,000까지의 정수이므로 long형으로 계산 필요.
        long max = 0;
        for (int v : values) {
            total += v;
            max = Math.max(v, max);
        }

        // 배열에서 가장 큰 요소가 N까지일 수 있으므로 N+1과 비교
        max = Math.max(max, values.length+1);

        // 1~특정값까지의 합은 n * (n+1) / 2가 됨
        return (int) ((max * (max + 1) / 2) - total);
    }
}
