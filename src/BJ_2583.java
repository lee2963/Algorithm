import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2583 {
    static int r, c;
    static int[][] map;
    static boolean[][] visited;
    static int[] nextX = {0, 1, 0, -1};
    static int[] nextY = {1, 0, -1, 0};
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;

            for (int j = startX; j <= endX; j++) {
                for (int m = startY; m <= endY; m++) {
                    map[j][m] = 1;
                }
            }
        }
        int cnt = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] == 0 && !visited[i][j]){
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        answer.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println(cnt);
        for (Integer integer : answer) {
            System.out.print(integer +" ");
        }
    }

    static void bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        int size = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + nextX[i];
                int ny = cur[1] + nextY[i];

                if(nx >= 0 && ny>= 0 && nx < r&& ny <c){
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            size++;
        }

        answer.add(size);
    }
}
