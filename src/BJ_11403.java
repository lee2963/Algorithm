import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11403 {
    static List<Integer>[] map;
    static int[][] answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new ArrayList[n];
        answer = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int road = Integer.parseInt(st.nextToken());

                if (road == 1) {
                    map[i].add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void dfs(int next, int start) {


        for (Integer node : map[next]) {
            if(!visited[node]){
                visited[node] = true;
                answer[start][node] = 1;
                dfs(node, start);
            }
        }
    }
}
