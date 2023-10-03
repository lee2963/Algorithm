import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17806 {
    static int[][] map;
    static int r, c;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] ==  1){
                    map[i][j] = -1;
                    q.add(new int[]{i, j});
                } else{
                    map[i][j] = 51;
                }
            }
        }

        bfs();
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                max = Math.max(map[i][j], max);
            }
        }

        System.out.println(max + 1);

    }

    static void bfs() {

        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if(map[nx][ny] != -1 && map[nx][ny] > map[now[0]][now[1]]+ 1){
                        q.add(new int[]{nx, ny});
                        map[nx][ny] = map[now[0]][now[1]] + 1;
                    }
                }
            }
        }

    }

}
