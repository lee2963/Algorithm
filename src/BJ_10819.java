import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10819 {
    static int n;
    static boolean[] visited;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(1, 0, arr[i]);
            visited[i] = false;
        }
        System.out.println(max);
    }

    static void dfs(int cnt, int sum, int pre) {
        if (cnt == n) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cnt + 1, sum + Math.abs(pre - arr[i]), arr[i]);
                visited[i] = false;
            }
        }

    }
}
