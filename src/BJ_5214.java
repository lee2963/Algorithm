import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_5214 {
    static int n, k, m;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n + m + 1];

        for (int i = 1; i <= n + m; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int tube = n + i + 1;
            for (int j = 0; j < k; j++) {
                int now = Integer.parseInt(st.nextToken());

                list[now].add(tube);
                list[tube].add(now);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, 1});
        boolean[] visited = new boolean[n + m + 1];
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == n) return now[1];

            for (Integer next : list[now[0]]) {
                if(!visited[next]){
                    visited[next] = true;
                    if(next > n) q.add(new int[] {next, now[1]});
                    else q.add(new int[]{next, now[1] + 1});
                }
            }
        }
        return -1;
    }
}
