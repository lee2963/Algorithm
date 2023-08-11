import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_10974 {
    static int n ;
    static boolean[] visited;
    static List<Integer> list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        list = new ArrayList<>();

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int cnt) {
        if(cnt == n){

            for (Integer integer : list) {
                sb.append(integer).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                dfs(cnt + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
