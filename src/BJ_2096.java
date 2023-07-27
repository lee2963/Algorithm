import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][3];
        dp[0] = arr[0].clone();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] += arr[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == 2) {
                    dp[i][j] += arr[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                } else{
                    dp[i][j] += arr[i][j] + Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j + 1]));
                }
            }
        }

        int answerMax = 0;
        for (int i = 0; i < 3; i++) {
            answerMax = Math.max(dp[n - 1][i], answerMax);
        }

        dp = new int[n][n];
        dp[0] = arr[0].clone();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] += arr[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == 2) {
                    dp[i][j] += arr[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                } else{
                    dp[i][j] += arr[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                }
            }
        }

        int answerMin = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            answerMin = Math.min(dp[n - 1][i], answerMin);
        }

        System.out.println(answerMax + " " + answerMin);
    }
}
