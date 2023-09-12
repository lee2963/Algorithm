import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17090 {
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        dp = new boolean[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(dfs(i, j)) answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= r || y >= c) {
            return true;
        }

        if(!visited[x][y]) {
            visited[x][y] = true;

            if (map[x][y] == 'U') {
                dp[x][y] = dfs(x - 1, y);
            } else if (map[x][y] == 'D') {
                dp[x][y] = dfs(x + 1, y);
            } else if (map[x][y] == 'L') {
                dp[x][y] = dfs(x, y - 1);
            } else if (map[x][y] == 'R') {
                dp[x][y] = dfs(x, y + 1);
            }
        }

        return dp[x][y];
    }
}
