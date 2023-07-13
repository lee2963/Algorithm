import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] num = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1;
        int len = 1;
        int answer = 0;
        num[arr[0]]++;
        while (right < n) {

            if (num[arr[right]] + 1 > k) {
                num[arr[left]]--;
                left++;
                len--;
            } else{
                num[arr[right]]++;
                right++;
                len++;
               answer =  Math.max(len, answer);
            }
        }

        System.out.println(answer);
    }
}
