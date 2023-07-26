import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14620 {
    static int[][] map;
    static boolean[][] visited;
    static int n, answer = Integer.MAX_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);

    }

    static void dfs(int sum, int idx) {

        if (idx == 3) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {

                if (!visited[i][j] && chk(i, j)) {
                    int val = map[i][j];
                    visited[i][j] = true;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        visited[nx][ny] = true;
                        val += map[nx][ny];
                    }

                    dfs(sum + val, idx + 1);

                    visited[i][j] = false;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }

    static boolean chk(int x, int y) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(visited[nx][ny]){
               return false;
            }
        }

        return true;
    }

}
