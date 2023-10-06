import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1113 {
    static int n, m;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        int max = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';

                max = Math.max(max, map[i][j]);
            }
        }

        for (int i = 1; i <= max; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[j][k] < i) {
                        bfs(j, k, i);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int x, int y, int target) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        map[x][y]++;

        int cnt = 1;
        boolean outside = false;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] < target) {
                        q.add(new int[]{nx, ny});
                        map[nx][ny]++;
                        cnt++;
                    }
                } else{
                    outside = true;
                }
            }
        }

        if(outside) return;

        answer += cnt;
    }
}
