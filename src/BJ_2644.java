import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2644 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int child = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());

            list[parent].add(child);
            list[child].add(parent);
        }

        visited[target1] = true;
        dfs(target2, target1, 0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }

    static void dfs(int target, int cur, int cnt) {

        if (cur == target) {
            min = Math.min(min, cnt);
            return;
        }

        for(Integer next : list[cur]){
            if (!visited[next]) {
                visited[next] = true;
                dfs(target, next, cnt + 1);
                visited[next] = false;
            }
        }
    }
}
