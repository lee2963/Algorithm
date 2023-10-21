import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1799 {
    static int n;
    static boolean[][] origin;
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, -1, 1};
    static int bCnt = 0;
    static int wCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        origin = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int now = Integer.parseInt(st.nextToken());

                if(now == 1){
                    origin[i][j] = true;
                } else {
                    origin[i][j] = false;
                }
            }
        }

        boolean[][] bMap = new boolean[n + 1][n + 1];
        bDfs(bMap, 1, 1, 0);


        boolean[][] wMap = new boolean[n + 1][n + 1];
        wDfs(wMap, 1, 2, 0);

        System.out.println(bCnt + wCnt);
    }

    static void bDfs(boolean[][] bMap, int x, int y, int cnt) {

        bCnt = Math.max(cnt, bCnt);

        if (y > n) {
            x += 1;

            if(x % 2 == 0) y = 2;
            else y = 1;
        }

        if(x > n) return;


        if(can(bMap, x, y)){
            bMap[x][y] = true;
            bDfs(bMap, x, y + 2, cnt + 1);
            bMap[x][y] = false;
        }

        bDfs(bMap, x, y + 2, cnt);
    }

    static void wDfs(boolean[][] wMap, int x, int y, int cnt) {

        wCnt = Math.max(cnt, wCnt);

        if (y > n) {
            x += 1;
            if(x % 2 == 0) y = 1;
            else y = 2;
        }

        if(x > n) return;

        if(can(wMap, x, y)){
            wMap[x][y] = true;
            wDfs(wMap, x, y + 2, cnt + 1);
            wMap[x][y] = false;
        }

        wDfs(wMap, x, y + 2, cnt);
    }


    static boolean can(boolean[][] map, int x, int y) {

        if(!origin[x][y]) return false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            for (int j = 1; j <= n; j++) {
                if(nx > 0 && ny > 0 && nx <= n && ny <= n) {
                    if(map[nx][ny]) return false;

                    nx += dx[i];
                    ny += dy[i];
                } else break;
            }
        }
        return true;
    }
}
