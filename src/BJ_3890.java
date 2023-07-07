import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3890 {
    static int[][] person;
    static boolean[] visited;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            person = new int[11][11];
            visited = new boolean[11];
            max = 0;
            for (int j = 0; j < 11; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < 11; k++) {
                    person[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 11; j++) {
                if (person[0][j] != 0) {
                    visited[j] = true;
                    dfs(1, person[0][j]);
                    visited[j] = false;
                }
            }

            System.out.println(max);
        }
    }

    static void dfs(int n, int sum) {
        if (n == 11) {
            for (int i = 0; i < 11; i++) {
                if (!visited[i]) {
                    return;
                }
            }

            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (!visited[i] && person[n][i] != 0) {
                visited[i] = true;
                dfs(n + 1, sum + person[n][i]);
                visited[i] = false;
            }
        }
    }
}
