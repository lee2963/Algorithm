import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int answer = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            int val = arr[left] + arr[right];

            if (val == m) {
                answer++;
                left++;
            } else if (val < m) {
                left++;
            } else{
                right--;
            }
        }
        System.out.println(answer);
    }
}
