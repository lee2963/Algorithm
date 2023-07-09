import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        int[] cnt = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        int[][] sum = new int[len + 1][4];
        int answer = 0;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);

            sum[i + 1][0] += sum[i][0];
            sum[i + 1][1] += sum[i][1];
            sum[i + 1][2] += sum[i][2];
            sum[i + 1][3] += sum[i][3];

            if (ch == 'A') {
                sum[i + 1][0]++;
            } else if (ch == 'C') {
                sum[i + 1][1]++;
            } else if (ch == 'G') {
                sum[i + 1][2]++;
            } else {
                sum[i + 1][3]++;
            }
        }

        for (int i = len; i >= n; i--) {
            if (sum[i][0] - sum[i - n][0] >= cnt[0] && sum[i][1] - sum[i - n][1] >= cnt[1] &&
                    sum[i][2] - sum[i - n][2] >= cnt[2] && sum[i][3] - sum[i - n][3] >= cnt[3]) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
