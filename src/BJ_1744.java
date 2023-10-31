import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int idx = n;
        for(int i = 0; i < n; i++){
            if(arr[i] > 0) {
                idx = i;
                break;
            }
        }

        long sum = 0;
        for(int i = 0; i < idx; i+= 2){
            if(i + 1 < idx) sum += arr[i] * arr[i + 1];
            else sum += arr[i];
        }

        for(int i = n - 1; i >= idx;){
            if(i - 1>= idx && arr[i] != 1 && arr[i - 1] != 1) {
                sum += arr[i] * arr[i - 1];
                i -= 2;
            } else {
                sum += arr[i];
                i--;
            }
        }

        System.out.println(sum);
    }
}
