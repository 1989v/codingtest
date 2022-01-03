package kr.got.codingtest.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 목표지점까지의 최단거리 구하기
 * https://github.com/ndb796/python-for-coding-test/blob/master/5/11.java
 * <p>
 * 각 요소가 0또는1로 구성된 n * m 크기의 graph에서
 * 그래프에서 0인 부분은 이동불가능 1인 부분으로만 이동가능 할 때,
 * (1,1) 지점(최 좌측상단)에서 출발하여
 * (n,m)지점까지 가기위한 최단거리를 구하시오.
 * <p>
 * 제약조건
 * - n과 m은 4~200까지 값
 */
public class ShortestDistance {
    // 그래프 범위
    public static int n, m;
    // 그래프
    public static int[][] graph = new int[201][201];

    // 상하좌우 이동할 방향 정의
    public static int dx[] = {-1, 1, 0, 0}; // 상,하
    public static int dy[] = {0, 0, -1, 1}; // 좌,우

    public static void main(String[] args) {
        /* 콘솔에 입력값 받아서 graph 초기화
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        // row 기준으로 입력된 문자열 받아옴
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();

            // column기준으로 str에서 입력된 문자열 받아옴
            for (int j = 0; j < m; j++) {
                // 입력된 문자열을 받아와 graph에 값(0 또는 1) 초기화
                graph[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        } */

        // 값을 바로 초기화.
        n = 5;
        m = 6;
        graph[0] = new int[]{1, 0, 1, 0, 1, 0};
        graph[1] = new int[]{1, 1, 1, 1, 1, 1};
        graph[2] = new int[]{0, 0, 0, 0, 0, 1};
        graph[3] = new int[]{1, 1, 1, 1, 1, 1};
        graph[4] = new int[]{1, 1, 1, 1, 1, 1};

        int result = solutionBfs(0, 0);
        System.out.println(result);
    }

    /**
     * 아이디어
     * - 그래프에서 이동가능한 각 노드 값(1)을
     * 해당 노드까지 이동한 거리로 갱신처리하여 목적지까지의 거리를 구함.
     */
    public static int solutionBfs(int x, int y) {

        // Queue를 선언 후 현재 노드를 담음
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        // 큐가 빌때 까지 반복
        while (!q.isEmpty()) {
            // 큐의 노드를 꺼내서 처리
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            // 현재 위치에서 이동가능한 사방으로의 위치(거리) 확인
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // 이동한 위치가 그래프 범위 안인지 확인
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }

                // 이동불가능한 벽(0)인 경우 무시
                if (graph[newX][newY] == 0) {
                    continue;
                }

                // 해당 노드를 처음 방문한 경우(값이 1인 경우)
                // 이전까지 거리 + 1로, 최단거리 기록 후 큐에 추가
                if (graph[newX][newY] == 1) {
                    graph[newX][newY] = graph[x][y] + 1;
                    q.offer(new Node(newX, newY));
                }


            }
        }

        // 가장 오른쪽 아래까지의 최단거리 반환(해당 그래프의 값을 리턴하면 됨 -> 방문시마다 최단거리를 기록했으므로)
        return graph[n-1][m-1];
    }
}

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}