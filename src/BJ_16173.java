import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16173 {
    static int n;
    static int[][] map;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
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

        if (bfs()) {
            System.out.println("HaruHaru");
            return;
        }

        System.out.println("Hing");
    }

    static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == n - 1 && now[1] == n - 1) {
                return true;
            }

            for (int i = 0; i < 2; i++) {
                int nx = now[0] + dx[i] * map[now[0]][now[1]];
                int ny = now[1] + dy[i] * map[now[0]][now[1]];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }

        }
        return false;
    }
}
