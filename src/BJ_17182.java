import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17182 {
    static int n;
    static int[][] dist;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        dist = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 10001);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(i != j){
                        dist[i][j] = Math.min(dist[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }

        visited[start] = true;
        dfs(1, start, 0);

        System.out.println(min);
    }

    static void dfs(int cnt, int now, int time) {
        if (cnt == n ) {
            min = Math.min(time, min);
            return;
        }

        for(int i = 0; i < n; i++){
            if(i != now && !visited[i]){
                visited[i] = true;
                dfs(cnt + 1, i, time + dist[now][i]);
                visited[i] = false;
            }
        }

    }
}
