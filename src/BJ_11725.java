import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11725 {
    static List<Integer>[] node;
    static int[] parent;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        node = new ArrayList[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++){
            node[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            node[node1].add(node2);
            node[node2].add(node1);
        }
        visited[1] = true;
        dfs(1);

        for(int i = 2; i <= n; i++){
            System.out.println(parent[i]
            );
        }
    }

    static void dfs(int cur){

        for (Integer next : node[cur]) {
            if(!visited[next]){
                visited[next] = true;
                parent[next] = cur;
                dfs(next);
            }
        }
    }
}
