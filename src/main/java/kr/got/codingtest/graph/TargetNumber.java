package kr.got.codingtest.graph;

/**
 * N개의 음이아닌 정수들을 각각 더하거나 빼서 목표로하는 타켓 값을 만들 수 있는 경우의 수를 리턴.
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 * <p>
 * [1,1,1,1,1] 배열이 주어질떄 타켓 값이 3이라면
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 위와 같이 총 5가지 경우의 수가 존재함.
 * <p>
 * 제약사항
 * - N은 2 ~ 20
 * - 각 숫자는 1 ~50
 * - 타켓값은 1 ~ 1,000
 */
public class TargetNumber {
    public static void main(String[] args) {
        int result = solution(new int[]{1, 1, 1, 1, 3}, 3);
        System.out.println(result);
    }

    public static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public static int dfs(int[] numbers, int target, int index, int num) {
        if (index == numbers.length) {
            return num == target ? 1 : 0;
        } else {
            return dfs(numbers, target, index + 1, num + numbers[index])
                    + dfs(numbers, target, index + 1, num - numbers[index]);
        }
    }
}
