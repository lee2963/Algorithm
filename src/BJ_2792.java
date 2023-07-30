import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        int left = 1, right = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }


        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                cnt += arr[i] / mid;

                if (arr[i] % mid != 0) {
                    cnt ++;
                }
            }

            if (cnt > n) {
                left = mid + 1;
            } else{
                right = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}
