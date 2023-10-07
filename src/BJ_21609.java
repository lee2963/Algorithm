import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_21609 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] info;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while(true){
            visited = new boolean[n][n];
            info = new int[4];
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] > 0) {
                        max = Math.max(bfs(i, j, info), max);
                    }
                }
            }



            if(max <= 1) break;

            removeBlock(info[0], info[1]);
            down();
            rotate();
            down();

            answer += info[2] * info[2];
       }

        System.out.println(answer);
    }

    static int bfs(int x, int y, int[] info){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int target = map[x][y];
        int cnt = 0;
        int rainbow = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(!visited[nx][ny]){
                        if (map[nx][ny] == target || map[nx][ny] == 0) {
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            cnt++;
            if(map[now[0]][now[1]] == 0) rainbow++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    visited[i][j] = false;
                }
            }
        }

        if(cnt > info[2]){
            info[0] = x;
            info[1] = y;
            info[2] = cnt;
            info[3] = rainbow;
        } else if (cnt == info[2]) {
            if (rainbow >= info[3]) {
                info[0] = x;
                info[1] = y;
                info[2] = cnt;
                info[3] = rainbow;
            }
        }

        return cnt;
    }

    static void removeBlock(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int target = map[x][y];
        map[x][y] = -2;

        while (!q.isEmpty()) {
            int[] now = q.poll();


            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (map[nx][ny] == target || map[nx][ny] == 0) {
                        q.add(new int[]{nx, ny});
                        map[nx][ny] = -2;
                    }
                }
            }
        }
    }

    static void down() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if(map[j][i] == -2){
                    for (int k = j - 1; k >= 0; k--) {
                        if(map[k][i] == -1){
                            break;
                        } else if (map[k][i] >= 0){
                            map[j][i] = map[k][i];
                            map[k][i] = -2;
                            break;
                        }
                    }
                }
            }
        }
    }

    static void rotate() {
        int[][] tmp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = map[j][n - 1 - i];
            }
        }

        map = tmp;

    }
}
