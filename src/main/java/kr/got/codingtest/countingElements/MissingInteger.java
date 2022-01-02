package kr.got.codingtest.countingElements;

import java.util.HashSet;
import java.util.Set;

/**
 * 주어진 시퀀스에서 발생하지 않는 가장 작은 양의 정수 찾기
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 * <p>
 * N개의 정수로 구성된 배열 A에서, 배열 A의 각 요소들 중 누락되거나,
 * 누락되지 않았다면 그다음 가장 작은 양의 정수를 반환
 * <p>
 * 예시
 * A = [1, 3, 6, 4, 1, 2]가 주어지면 누락된 5를 반환
 * A = [1, 2, 3]이 주어지면 누락되진 않았으므로 다음으로 가장작은 4를 반환
 * A = [-1, -3]이 주어지면 1을 반환.
 * <p>
 * 제약사항
 * - N은 1 ~ 100,000 범위 내의 정수
 * - 배열 A의 각 요소는 -1,000,000 ~ 1,000,000 범위 내의 정수.
 */
public class MissingInteger {
    public static void main(String[] args) {
        int result = solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println(result);
    }

    public static int solution(int[] values) {
        // set 자료구조 사용
        Set<Integer> set = new HashSet<>();

        for (int v : values) {
            // 값이 0보다 큰 경우만 Set에 추가
            if (v > 0) {
                set.add(v);
            }
        }

        int result = 1;
        // 양의정수 1부터 set에 추가된 사이즈+1(누락값 없는 배열일때 다음 요소 출력을 위함)까지 순회
        for (int i = 1; i <= set.size() + 1; i++) {
            if (!set.contains(i)) {
                result = i;
                break;
            }
        }

        return result;
    }

}
