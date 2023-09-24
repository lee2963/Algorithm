import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070 {
    static int[][] map;
    static int n;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0);
        System.out.println(answer);

    }
    static void dfs(int x, int y, int dir){
        if (x == n - 1 && y == n - 1) {
            answer++;
            return;
        }

        if(dir == 0){
            if (y + 1 < n && map[x][y + 1] == 0) {
                dfs(x , y + 1, 0);
            }
        } else if(dir == 1){
            if(x + 1 < n && map[x + 1][y] == 0){
                dfs(x + 1, y, 1);
            }
        } else if(dir == 2){
            if (y + 1 < n && map[x][y + 1] == 0) {
                dfs(x , y + 1, 0);
            }

            if(x + 1 < n && map[x + 1][y] == 0){
                dfs(x + 1, y, 1);
            }
        }

        if (x + 1 < n && y + 1 < n && map[x + 1][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }

    }
}
