import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int money = Integer.parseInt(br.readLine());

        while (left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (mid > arr[i]) {
                    sum += arr[i];
                } else{
                    sum += mid;
                }
            }

            if (sum <= money) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        System.out.println(left - 1);
    }
}
