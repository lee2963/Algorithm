import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206 {
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < c; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs(r, c);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(min);

    }

    static void bfs(int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 1});
        boolean[][][] visited = new boolean[n][m][2];
        visited[0][0][0] = true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == n - 1 && cur[1] == m - 1){
                min = Math.min(min, cur[3]);
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(map[nx][ny] == 1){
                        if(cur[2] == 0 && !visited[nx][ny][1]){
                            visited[nx][ny][1] = true;
                            q.add(new int[]{nx, ny, 1, cur[3] + 1});
                        }
                    } else{
                        if(!visited[nx][ny][cur[2]]){
                            visited[nx][ny][cur[2]] = true;
                            q.add(new int[]{nx, ny, cur[2], cur[3] + 1});
                        }
                    }
                }
            }
        }
    }
}
