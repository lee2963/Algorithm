import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[n - 1] - arr[0] + 1;

        while(left < right){

            int mid = (left + right) / 2;

            if (count(mid) < c) {
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }
    static int count(int dist){

        int cnt = 1;
        int last = arr[0];

        for(int i = 1; i < arr.length; i++){

            if(arr[i] - last >= dist){
                cnt++;
                last = arr[i];
            }
        }

        return cnt;
    }
}
