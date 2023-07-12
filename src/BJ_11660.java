import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int[][] map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) + map[i][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int[] pair = new int[4];
            int answer = 0;

            for (int j = 0; j < 4; j++) {
                pair[j] = Integer.parseInt(st.nextToken());
            }


            for (int j = pair[0]; j <= pair[2]; j++) {
                answer += (map[j][pair[3]] - map[j][pair[1] - 1]);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
