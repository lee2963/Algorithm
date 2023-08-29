import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14225 {
    static int n;
    static int[] arr;
    static boolean[] chk;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        int sum = 0;
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        visited = new boolean[sum + 2];

        for (int i = 0; i < n; i++) {
            dfs(i, arr[i]);
        }

        for (int i = 1; i <= sum + 1; i++) {
            if(!visited[i]){
                System.out.println(i);
                return;
            }
        }

    }

    static void dfs(int idx, int sum) {

        visited[sum] = true;
        for (int i = idx + 1; i < n; i++) {
            dfs(i, sum + arr[i]);
        }
    }
}
