import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3151 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if(arr[i] > 0) break;

            int left = i + 1;
            int right = n - 1;

            while(left < right){
                int l = arr[left];
                int r = arr[right];
                int now = arr[i] + l + r;

                if(now == 0){
                    if(l == r){
                        answer += (right - left) * (right - left + 1) / 2;
                        break;
                    } else {
                        int lc = 0;
                        while(left < n && l == arr[left]){
                            lc++;
                            left++;
                        }

                        int rc = 0;
                        while(right >= 0 && r == arr[right]){
                            rc++;
                            right--;
                        }
                        answer += lc * rc;
                    }
                } else if(now > 0){
                    right--;
                } else{
                    left++;
                }
            }
        }

        System.out.println(answer);
    }

}
