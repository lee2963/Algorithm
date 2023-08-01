import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2961 {
    static int n, answer = Integer.MAX_VALUE;
    static int[] s, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        s = new int[n];
        b = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0);
        System.out.println(answer);
    }

    static void dfs(int idx, int sin, int bitter) {

        for (int i = idx; i < n; i++) {
            answer = Math.min(Math.abs((sin * s[i]) - (bitter + b[i])), answer);

            dfs(i + 1, sin * s[i], bitter + b[i]);
        }

    }
}
