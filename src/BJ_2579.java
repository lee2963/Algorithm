import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[301];
        int[] dp = new int[301];
        for (int i = 1; i <= m; i++)
            arr[i] = Integer.parseInt(br.readLine());

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(arr[1], arr[2]) + arr[3];

        for (int n = 4; n <= m; n++) {
            dp[n] = Math.max(dp[n - 3] + arr[n - 1], dp[n - 2]) + arr[n];
        }

        System.out.println(dp[m]);
    }
}