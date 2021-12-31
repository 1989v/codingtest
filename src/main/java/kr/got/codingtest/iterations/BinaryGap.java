package kr.got.codingtest.iterations;

/**
 * 이진수 문자열 1 사이의 0개수 구하기
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 * <p>
 * 문제: 정수가 주어졌을때 해당 정수의 이진수 값의 각 1과 1사이의 0의 개수가 가장 큰 값을 리턴하시오.
 * 예시: 정수 5653이 주어졌을때, 이진수로 변환한 1011000010101을 구하고, 여기서 연속된 0이 가장 큰 개수인 4를 리턴하면 정답.
 */
public class BinaryGap {
    public static void main(String[] args) {
        int result = solution(5653);

        System.out.println(result);
    }

    public static int solution(int value) {
        // Integer.toBinaryString을 통해 정수값을 이진수로 변환
        String s = Integer.toBinaryString(value);
        int count = 0;  // 0의 개수 카운팅
        int max = 0;    // 0이 가장 많은 경우의 그 갯수

        // 이진문자열을 한글자씩 순회하며
        for (int i = 0; i < s.length(); i++) {

            // 값이 1일때는 max값 비교를, 0의 개수를 카운팅한 count 값을 초기화처리.
            if ("1".equals(String.valueOf(s.charAt(i)))) {
                max = Math.max(count, max);
                count = 0;
            }

            // 0일때는 count를 1씩 증가.
            else if ("0".equals(String.valueOf(s.charAt(i)))) {
                count++;
            }

        }

        return max;
    }
}
