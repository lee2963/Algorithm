import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2251 {
    static boolean[][] visited;
    static int[] bucket = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            bucket[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[bucket[0] + 1][bucket[1] + 1];
        dfs(0, 0);

        for (int i = bucket[1]; i >= 0; i--) {
            if(visited[0][i]){
                System.out.print(bucket[2] - i + " ");
            }
        }

    }

    static void dfs(int a, int b) {

        int c = bucket[2] - a - b;
        int spaceA = bucket[0] - a;
        int spaceB = bucket[1] - b;

        if (visited[a][b]) {
            return;
        }

        visited[a][b] = true;


        if (a > 0) {
            int AToB = Math.min(a, spaceB);
            dfs(a - AToB, b + AToB);

            int AToC = Math.min(a, bucket[2] - c);
            dfs(a - AToC, b);
        }

        if (b > 0) {
            int BToA = Math.min(b, spaceA);
            dfs(a + BToA, b - BToA);

            int BToC = Math.min(b, bucket[2] - c);
            dfs(a, b - BToC);
        }

        if (c > 0) {
            int CToA = Math.min(c, spaceA);
            dfs(a + CToA, b);

            int CToB = Math.min(c, spaceB);
            dfs(a , b + CToB);
        }
    }
}
