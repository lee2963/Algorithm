import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        long left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(arr[i], right);
        }

        right = right * m;
        long answer = Long.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (int i = 0; i < n; i++) {
                cnt += mid / arr[i];

                if (cnt > m) {
                    break;
                }
            }

            if (cnt < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        System.out.println(answer);
    }
}
