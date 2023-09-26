import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16938 {
    static int n, l, r, x;
    static int answer = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        dfs(0, 0, Integer.MAX_VALUE, 0);

        System.out.println(answer);

    }

    static void dfs(int sum, int idx, int min, int max) {

        if (sum >= l && sum <= r) {
            if(max - min >= x) answer++;
        }

        if(sum > r || idx >= n) return;

        for (int i = idx; i < n; i++) {
            dfs(sum + arr[i], i + 1, Math.min(arr[i], min), Math.max(max, arr[i]));
        }

    }
}
