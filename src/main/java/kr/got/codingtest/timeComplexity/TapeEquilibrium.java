package kr.got.codingtest.timeComplexity;

/**
 * 정수형 배열에서 특정 요소 위치를 기준으로 좌,우 요소들의 합의 차(절대값)가 최소가 되는 값을 리턴.
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 *
 * int[] a = new int[]{3, 1, 2, 4, 3}이 주어질때
 * a[0] ~ a[2]의 요소를 더한 합(3+1+2 = 6)과
 * a[3] ~ a[4]의 요소를 더한 합(4+3 = 7)의 차(6-7 = -1)의 절대값(1)이 가장 작은 값이 되므로 답은 1.
 *
 * 제약사항:
 *  - 배열의 크기는 2 ~ 100,000 범위의 정수
 *  - 각 요소는 -1,000 ~ 1,000 범위의 정수
 */
public class TapeEquilibrium {
    public static void main(String[] args) {
        int result = solution(new int[]{3, 1, 2, 4, 3});
        System.out.println(result);
    }

    /**
     * 아이디어:
     *  - 요소의 값이 음수일 수 있으므로 결국 배열의 크기만큼 순회해야 함.
     *  - 각 인덱스 위치에서 테이프를 나눌때 좌,우 합의 차를 구해서 그 차이가 최소값인 값을 리턴.
     */
    public static int solution(int[] values) {
        // 최초 배열을 나눔
        int tapeTotal = values[0];

        int tapeOtherTotal = 0;
        for (int i = 1; i < values.length; i++) {
            tapeOtherTotal += values[i];
        }

        // 첫번째로 나눈 값의 차의 절대값
        int min = Math.abs(tapeTotal - tapeOtherTotal);

        // 다음 위치에서 순차적으로 나눠 그 차를 구하고, 이전까지 구해진 차와 비교하여 더 작은 값을 기록.
        for (int i = 1; i < values.length; i++) {
            tapeTotal += values[i];
            tapeOtherTotal -= values[i];
            int nowMin = Math.abs(tapeTotal - tapeOtherTotal);
            if (nowMin < min) {
                min = nowMin;
            }
        }

        return min;
    }
}
