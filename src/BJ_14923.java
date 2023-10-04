import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14923 {
    static int n, m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] start = new int[2];
        int[] end = new int[2];

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            start[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            end[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(start, end);

    }

    static void bfs(int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];

        visited[start[0]][start[1]][0] = true;
        q.add(new int[]{start[0], start[1], 0, 0});

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == end[0] && now[1] == end[1]){
                System.out.println(now[3]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(map[nx][ny] == 0){
                        if(!visited[nx][ny][now[2]]){
                            visited[nx][ny][now[2]] = true;
                            q.add(new int[]{nx, ny, now[2], now[3] + 1});
                        }
                    } else if(map[nx][ny] == 1){
                        if (now[2] == 0 && !visited[nx][ny][now[2] + 1]) {
                            visited[nx][ny][now[2] + 1] = true;
                            q.add(new int[]{nx, ny, now[2] + 1, now[3] + 1});
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
