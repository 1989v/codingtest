package kr.got.codingtest.timeComplexity;

/**
 * 위치 X에서 Y로의 최소 점프 횟수
 * 세개의 정수 X, Y, D(점프 거리)가 주어졌을때, X에서 출발하여 Y보다 크거나 같은 위치에 도달하기 위한 최소 점프 횟수.
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 * X=10, Y=85, D=30일때 10+30=40, 40+30=70, 70+30=100 총 3회
 * 제약사항: X,Y,D의 값은 1~1,000,000,000이고, X<=Y임.
 */
public class FrogJmp {
    public static void main(String[] args) {
        int result = solution(10, 85, 30);
        int resultBetter = solutionBetter(10, 85, 30);
        int resultBest = solutionBest(10, 85, 30);

        System.out.println(result);
        System.out.println(resultBetter);
        System.out.println(resultBest);
    }

    /**
     * 첫번째 내 답
     * 시간초과
     */
    public static int solution(int x, int y, int d) {
        int count = 0;
        while (x < y) {
            x += d;
            count++;
        }
        return count;
    }

    /**
     * 두번째 수정한 답
     */
    public static int solutionBetter(int x, int y, int d) {
        /**
         x + ?d >= y
         ?d >= y-x;

         85-10 = 75

         75/30 = 2.5이므로 2가 됨.
         75%30=15 나머지가 0보다 크므로 1회 추가
         */
        return (y-x)/d + ((y-x)%d > 0 ? 1 : 0);
    }

    /**
     * 반올림을 통한 답 유도
     */
    public static int solutionBest(int x, int y, int d) {
        return (int) Math.ceil((y-x) / (double) d);
    }
}
