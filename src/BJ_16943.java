import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16943 {
    static char[] numA;
    static int numB;
    static boolean[] visited;
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numA = st.nextToken().toCharArray();
        numB = Integer.parseInt(st.nextToken());

        visited = new boolean[numA.length];

        dfs(0, 0, numA.length);
        System.out.println(max);

    }

    static void dfs(int cnt, int num, int len) {

        if (cnt == len) {
            if (num < numB) {
                max = Math.max(num, max);
            }

        }

        for (int i = 0; i < len; i++) {
            if(visited[i] || (cnt == 0 && (numA[i] - '0') == 0)) continue;
            if(num * 10 + (numA[i] - '0') > numB) continue;

            visited[i] = true;
            dfs(cnt + 1,num * 10 +(numA[i] - '0'), len);
            visited[i] = false;
        }
    }
}
