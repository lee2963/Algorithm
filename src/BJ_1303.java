import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1303 {
    static int[][] map;
    static boolean[][] visited;
    static int r, c;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if(input[j] == 'W') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }

        int[] answer = new int[2];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j]) {
                    int cnt = bfs(new int[]{i, j});

                    answer[map[i][j]] += cnt * cnt;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    static int bfs(int[] start) {

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        int target = map[start[0]][start[1]];
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (!visited[nx][ny] && map[nx][ny] == target) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}
