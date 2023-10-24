import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] input = new int[r][c];
        int[][] dp = new int[r][c];

        int max = 0;

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                input[i][j] = str.charAt(j) - '0';

                if(input[i][j] == 1) max = 1;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dp[i][j] = input[i][j];
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if(input[i][j] == 1){
                    if(dp[i - 1][j - 1] >= 1 && dp[i - 1][j] >= 1 && dp[i][j - 1] >= 1){
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }

        System.out.println(max * max);
    }
}
