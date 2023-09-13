import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17836 {
    static int r, c;
    static int[][] map;
    static boolean[][] visited;
    static int[] sword;
    static boolean chk = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new boolean[r][c];
        sword = new int[3];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = bfs(0, 0, 0, 0);

        if(chk) {
            visited = new boolean[r][c];
            answer = Math.min(answer, bfs(sword[0], sword[1], sword[2], 1));

        }
        if (answer == Integer.MAX_VALUE || answer > t) {
            System.out.println("Fail");
            return;
        }

        System.out.println(answer);
    }

    static int bfs(int x, int y, int cnt,int mode){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, cnt});
        visited[x][y] = true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == r - 1 && now[1] == c - 1){
                return now[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny, now[2] + 1});
                        } else if(map[nx][ny] == 2){
                            visited[nx][ny] = true;
                            sword[0] = nx;
                            sword[1] = ny;
                            sword[2] = now[2] + 1;
                            chk = true;
                        } else if(map[nx][ny] == 1 && mode == 1){
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny, now[2] + 1});
                        }
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
