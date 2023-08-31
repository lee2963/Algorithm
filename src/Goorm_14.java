import java.io.*;
import java.util.*;

class Goorm_14 {
    static List<Integer>[] node;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        node = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++){
            node[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            node[a].add(b);
            node[b].add(a);
        }

        for(int i = 1; i <=n; i++){
            Collections.sort(node[i]);
        }

        dfs(k, 1);

    }
    static void dfs(int cur, int cnt){
        visited[cur] = true;
        boolean flag = false;

        for(Integer next : node[cur]){
            if(!visited[next]){
                flag = true;
                dfs(next, cnt + 1);
                break;
            }
        }

        if(!flag){
            System.out.println(cnt + " "+ cur);
        }
    }
}