import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_4803 {
    static List<Integer>[] map;
    static boolean[] visited;
    static int n, m;
    static boolean chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int idx = 0;
        while (true) {
            idx++;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) return;

            map = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                map[i] = new ArrayList<>();
            }

            visited = new boolean[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                map[parent].add(child);
                map[child].add(parent);
            }
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    if(dfs(-1, i)) answer++;
                }
            }

            if (answer == 0) {
                System.out.println("Case " + idx + ": No trees."  );
            } else if (answer == 1) {
                System.out.println("Case " + idx + ": There is one tree."  );
            } else{
                System.out.println("Case " + idx + ": A forest of "+answer+" trees."  );
            }
        }
    }

    static boolean dfs(int root, int node) {

        for (Integer next : map[node]) {
            if(root == next) continue;
            if (visited[next]) {
                return false;
            } else{
                visited[next] = true;
                if(!dfs(node, next)) return false;
            }
        }
        return true;
    }
}
