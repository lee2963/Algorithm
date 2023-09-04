import java.io.*;
import java.util.*;

class Goorm_16 {
    static List<Integer>[] group;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        group = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        boolean[][] bridge = new boolean[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            group[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            bridge[from][to] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(bridge[i][j] && bridge[j][i]){
                    group[i].add(j);
                    group[j].add(i);
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                visited[i] = true;
                answer++;
                dfs(i);
            }
        }
        System.out.print(answer);
    }
    static void dfs(int node){

        for(Integer next : group[node]){
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }
}