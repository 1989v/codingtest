package kr.got.codingtest.graph;

/**
 * DFS, 0과 1로 구성된 N(row) * M(column) 크기의 표에서 0으로만 연결된 개수를 구하시오.
 * https://github.com/ndb796/python-for-coding-test/blob/master/5/10.java
 *
 * 예시
 * 00110
 * 00011
 * 11111
 * 00000
 * 위와 같이 주어진다면 0으로만 연결된 개수는 총 3개임
 * 
 * 제약사항
 * N, M은 1 ~ 1,000 범위내의 정수수
 */
public class ConnectedComponents {
    // 그래프 범위
    public static int n, m;
    // 그래프
    public static int[][] graph = new int[1000][1000];

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
        n = 4;
        m = 5;
        graph[0] = new int[]{0, 0, 1, 1, 0};
        graph[1] = new int[]{0, 0, 0, 1, 1};
        graph[2] = new int[]{1, 1, 1, 1, 1};
        graph[3] = new int[]{0, 0, 0, 0, 0};

        // 생성된 graph를 순회하여 0으로 인접된 노드 수 계산
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    /**
     * 특정 요소에서 이동 가능한 모든 요소를 방문처리하고
     * 더 이상 방문처리할 요소가 없을때마다 카운팅처리
     * 전체 요소를 모두 순회한 경우 종료하고 카운트 반환.
     */
    public static boolean dfs(int x, int y) {
        if (x < 0 || x >= n
                || y < 0 || y >= m) {
            return false;
        }

        // 방문가능한 값은 0, 0일때 방문
        if (graph[x][y] == 0) {
            // 해당 좌표의 그래프값이 0이었던걸 1로 변경해서 방문처리함.
            // 1로 변경하여 방문처리할 경우 더이상 방문하지 않게됨.
            graph[x][y] = 1;

            // graph[x][y]와 사방으로 연결된 0인 노드들을 dfs로 실행해 방문여부 갱신.
            dfs(x - 1, y); // 상
            dfs(x + 1, y); // 하
            dfs(x, y - 1); // 좌
            dfs(x, y + 1); // 우
            return true;
        }

        return false;
    }
}
