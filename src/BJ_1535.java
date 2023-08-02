import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1535 {
    static int n;
    static int[] L, J;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        L = new int[n];
        J = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        dfs(100, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int life, int sum , int idx) {

        if (life <= 0) {
            return;
        }
        answer = Math.max(sum, answer);
        for (int i = idx; i < n; i++) {
            if (life - L[i] > 0) {
                dfs(life - L[i], sum + J[i], i + 1);
            }
        }
    }
}
