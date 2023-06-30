import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2];
        int prePrice = 0;

        for (int i = 1; i <= n; i++) {

            if(arr[i][0] + i < n + 2) {

                dp[i] = Math.max(prePrice, dp[i]);
                dp[arr[i][0] + i] = Math.max(dp[arr[i][0] + i], arr[i][1] + dp[i]);
            }

            prePrice = Math.max(prePrice, dp[i]);
        }

        System.out.println(Math.max(dp[n + 1], prePrice));
    }
}
