import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);

        for (int i = 0; i < b; i++) {
            int idx = Integer.parseInt(br.readLine());

            arr[idx] -= 1;
        }

        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += arr[i];
        }

        int left = 1;
        int right = k + 1;

        int max = sum;
        while (right <= n) {
            sum -= arr[left];
            sum += arr[right];

            max = Math.max(sum, max);
            left++;
            right++;
        }

        System.out.println(k - max);
    }
}
