import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16946 {
    static int n, m;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }


        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 0){
                    bfs(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                sb.append(map[i][j] % 10);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        List<int[]> wall = new ArrayList<>();

        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(!visited[nx][ny] && map[nx][ny] == 0){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                     }

                    if(!visited[nx][ny] && map[nx][ny] != 0){
                        visited[nx][ny] = true;
                        wall.add(new int[]{nx, ny});
                    }
                }
            }
            cnt++;
        }

        for (int[] point : wall) {
            map[point[0]][point[1]] += cnt;
            visited[point[0]][point[1]] = false;
        }
    }
}
