import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        Map<Integer, Long> map = new HashMap<>();
        long cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1] + Integer.parseInt(st.nextToken());

            if (arr[i] == k) {
                cnt++;
            }

            if (map.containsKey(arr[i] - k)) {
                cnt += map.get(arr[i] - k);
            }

            map.put(arr[i], map.getOrDefault(arr[i], 0L) + 1);
        }

        System.out.println(cnt);
    }
}
