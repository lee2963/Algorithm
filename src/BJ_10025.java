import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] map = new long[1000001];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[x] = g;
        }
        long sum = 0;
        long max = 0;
        for (int i = 0; i <= 1000000; i++) {

            if (i >= 2 * m + 1) {
                sum -= map[i - (2 * m) - 1];
            }
            sum += map[i];

            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
