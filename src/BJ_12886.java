import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_12886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(bfs(arr)){
            System.out.println(1);
            return;
        }
        System.out.println(0);

    }

    static boolean bfs(int[] arr) {

        if((arr[0] + arr[1] + arr[2]) % 3 != 0) return false;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[1501][1501];
        visited[arr[0]][arr[1]] = true;
        q.add(arr);

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == now[1] && now[1] == now[2]) {
                return true;
            }

            if(now[0] != now[1]){
                int x = now[0] > now[1] ? now[0] - now[1] : now[0] + now[0];
                int y = now[1] > now[0] ? now[1] - now[0] : now[1] + now[1];

                if (!visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new int[]{x, y, now[2]});
                }
            }

            if(now[0] != now[2]){
                int x = now[0] > now[2] ? now[0] - now[2] : now[0] + now[0];
                int y = now[2] > now[0] ? now[2] - now[0] : now[2] + now[2];

                if (!visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new int[]{x, now[1], y});
                }
            }

            if(now[1] != now[2]){
                int x = now[1] > now[2] ? now[1] - now[2] : now[1] + now[1];
                int y = now[2] > now[1] ? now[2] - now[1] : now[2] + now[2];

                if (!visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new int[]{now[0], x, y});
                }
            }


        }
        return false;
    }
}
