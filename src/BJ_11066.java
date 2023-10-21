import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[k + 1][n + 1];

        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= k; i++) {
            for(int j = 0; j <=n; j++){

                for (int m = 0; m <= j; m++) {
                    dp[i][j] += dp[i - 1][m];
                    dp[i][j] %= 1000000000;
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}
