import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16929 {
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for(int i = 0; i < r; i++){
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                visited = new boolean[r][c];
                visited[i][j] = true;
                if (dfs(i, j, i, j, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");

    }

    static boolean dfs(int x, int y, int startX, int startY, int cnt) {

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if(map[nx][ny] == map[x][y] && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(dfs(nx, ny, startX, startY, cnt + 1)) return true;
                } else if(map[nx][ny] == map[x][y] && cnt >= 4 && nx == startX && ny == startY){
                    return true;
                }
            }
        }
        return false;
    }
}
