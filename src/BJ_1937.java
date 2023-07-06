import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1937 {
    static int n;
    static int[][] map;
    static int[][] dp;
    static int[] nextX = {0, 1, 0, -1};
    static int[] nextY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }

        System.out.println(answer);
    }

    static int dfs(int x, int y) {

        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        dp[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + nextX[i];
            int ny = y + nextY[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[x][y] < map[nx][ny]) {
                    dp[x][y] = Math.max(dfs(nx, ny) + 1, dp[x][y]);
                }
            }
        }

        return dp[x][y];
    }
}
