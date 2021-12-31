package kr.got.codingtest.arrays;

/**
 * int 배열값을 주어진 수만큼 순환(배열의 각 인덱스 요소를 우측으로 하나씩 쉬프트, 마지막 요소를 첫번째 순서로)한 최종 배열 형태를 리턴하시오.
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 * [3, 8, 9, 7, 6], 3이 주어질 경우 결과값은 [9, 7, 6, 3, 8]
 * 제약사항: 횟수는 0~100, int 배열의 요소는 -1000~1000
 */
public class CyclicRatations {
    public static void main(String[] args) {
        int[] result = solution(new int[]{3, 8, 9, 7, 6}, 3);
        int[] result2 = solutionShorter(new int[]{3, 8, 9, 7, 6}, 3);
        int[] result3 = solutionShorten(new int[]{3, 8, 9, 7, 6}, 3);

        System.out.println(intArrayToString(result));
        System.out.println(intArrayToString(result2));
        System.out.println(intArrayToString(result3));
    }

    /**
     * 내 솔루션
     */
    public static int[] solution(int[] values, int cnt) {
        if (values.length == 0 || cnt % values.length == 0) {
            return values;
        }

        int[] result = new int[values.length];
        for (int i = 0; i < cnt; i++) {
            result = new int[values.length];
            for (int j = 0; j < values.length; j++) {
                result[j] = values[j == 0 ? values.length - 1 : j - 1];
            }
            values = result;
        }

        return result;
    }

    /**
     * 1차 향상된 솔루션
     * 결과배열을 별도로 생설할 필요없이 배열의 마지막값을 이전 값으로 차례로 대체,
     * 첫번째값만 미리 구해놓은 값으로 대체
     */
    public static int[] solutionShorter(int[] values, int cnt) {
        if (values.length == 0 || cnt % values.length == 0) {
            return values;
        }

        for (int i = 0; i < cnt; i++) {
            int firstNum = values[values.length - 1];
            for (int j = values.length - 1; j > 0; j--) {
                values[j] = values[j - 1];
            }

            values[0] = firstNum;
        }

        return values;
    }

    /**
     * 축약형 솔루션
     * 인덱스가 시프트되는 기준을 토대로 (i+cnt) % values.length 라는 공식 도출.
     * cnt가 4, values개수가 총 6개일때
     * 0번 요소는 (0+4) % 6 = 4 % 6 = 4
     * 1번 요소는 (1+4) % 6 = 5 % 6 = 5
     * 2번 요소는 (2+4) % 6 = 6 % 6 = 0
     * 3번 요소는 (3+4) % 6 = 7 % 6 = 1
     * 4번 요소는 (4+4) % 6 = 8 % 6 = 2
     * 5번 요소는 (5+4) % 6 = 9 % 6 = 3
     * 위와 같은 기준 공식을 도출하여 간략하게 풀이함.
     */
    public static int[] solutionShorten(int[] values, int cnt) {
        int[] result = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            result[(i+cnt) % values.length] = values[i];
        }

        return result;
    }

    public static String intArrayToString(int[] result) {
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            resultStr.append(result[i]);

            if (i < result.length - 1) {
                resultStr.append(",");
            }
        }

        return resultStr.toString();
    }
}
