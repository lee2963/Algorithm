import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_20058 {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        n = (int) Math.pow(2, n);
        map = new int[n][n];
        visited = new boolean[n][n];
        int[] arr = new int[q];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] = (int) Math.pow(2, arr[i]);
        }


        for (int i = 0; i < q; i++) {
            map = rotate(arr[i]);
            map = melt();

        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(sum);
        System.out.println(max);
    }

    static int[][] rotate(int q) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i += q) {
            for(int j = 0; j < n; j += q){

                for (int k = 0; k < q; k++) {
                    for(int m = 0; m < q; m++){
                        arr[i + k][ j + m] = map[i + q - m - 1][k + j];
                    }
                }
            }
        }
        return arr;
    }

    static int[][] melt() {
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;

                if(map[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                            if (map[nx][ny] > 0) {
                                cnt++;
                            }
                        }
                    }
                    if (cnt >= 3) {
                        arr[i][j] = map[i][j];
                    } else{
                        arr[i][j] = map[i][j] - 1;
                    }
                }
            }
        }
        return arr;
    }


    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] > 0) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            sum += map[now[0]][now[1]];
            cnt++;
        }
        return cnt;
    }
}


