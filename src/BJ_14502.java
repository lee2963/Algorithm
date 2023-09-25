import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14502 {
    static int[][] map;
    static int r, c;
    static List<int[]> virus;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        virus = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        dfs(0);

        System.out.println(max);


    }

    static void dfs(int cnt){
        if(cnt == 3){
            bfs();
            return;
        }

        for (int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++){
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] copyMap = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        for (int[] ints : virus) {
            q.add(new int[] {ints[0], ints[1]});
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(copyMap[i][j] == 0) cnt++;
            }
        }

        max = Math.max(max, cnt);

    }
}
