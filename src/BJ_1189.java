import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1189 {
    static int r, c, k;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited[r-1][0] = true;
        dfs(1, r - 1, 0);

        System.out.println(answer);
    }

    static void dfs(int cnt, int x, int y) {
        if (cnt == k) {
            if (x == 0 && y == c - 1) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if(!visited[nx][ny] && map[nx][ny] == '.'){
                    visited[nx][ny] = true;
                    dfs(cnt + 1, nx, ny);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
