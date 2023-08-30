import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_17425 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        long[] fx = new long[1000001];
        long[] dp = new long[1000001];


        Arrays.fill(fx, 1);

        for (int i = 2; i < fx.length; i++) {
            for (int j = 1; i * j < fx.length; j++) {
                fx[i * j] += i;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + fx[i];
        }

        StringBuilder answer = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());

            answer.append(dp[n]).append("\n");
        }

        System.out.println(answer);
    }
}