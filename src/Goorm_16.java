import java.io.*;
import java.util.*;

class Goorm_16 {
    static boolean[][] bridge;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        bridge = new boolean[n + 1][n + 1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            bridge[from][to] = true;
        }

        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                answer++;
                dfs(i, n);
            }
        }
        System.out.print(answer);
    }
    static void dfs(int node, int n){
        visited[node] = true;

        for(int i = 1; i <= n; i++){
            if(!visited[i] && bridge[node][i]){
                if(bridge[i][node]){
                    dfs(i, n);
                }
            }
        }
    }
}