package kr.got.codingtest.countingElements;

/**
 * 주어진 배열이 순열(1~N 까지 차례로 1씩 증가)인지 여부, 맞으면 1 아니면 0 반환
 * https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 * <p>
 * {4, 1, 3, 2}는 순열이므로 1, {4, 1, 3}은 2가 없으므로 0 리턴
 * <p>
 * 제약사항
 * - 배열의 요소 개수는 1~100,000 범위의 정수
 * - 배열의 요소는 1~1,000,000,000 범위의 정수
 */
public class PermCheck {
    public static void main(String[] args) {
        int result = solution(new int[]{4, 1, 3, 2});

        System.out.println(result);
    }

    // 순열합을 구하는 공식은 'N * (N+1) /2'임을 활용하여 순열여부를 확인.
    public static int solution(int[] values) {
        int max = 0;
        int total = 0;
        for (int v : values) {
            total += v;
            max = Math.max(max, v);
        }

        return (double)total == (double) max * (max + 1) / 2 ? 1 : 0;
    }
}
