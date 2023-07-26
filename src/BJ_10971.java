import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10971 {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(0, i, 0, i);
            visited[i] = false;
        }


        System.out.println(min);
    }

    static void dfs(int cnt, int row, int sum, int start) {

        if (cnt == n - 1) {
            if(map[row][start] != 0) min = Math.min(sum + map[row][start], min);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[row][i] != 0) {
                visited[i] = true;
                dfs(cnt + 1, i,sum + map[row][i], start);
                visited[i] = false;
            }
        }
    }
}
