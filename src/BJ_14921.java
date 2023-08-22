import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int l = 0, r = n - 1;
        int min = Integer.MAX_VALUE;
        while(l < r){

            if (Math.abs(arr[r] + arr[l]) < Math.abs(min)) {
                min = arr[r] + arr[l];
            }

            if(arr[r] + arr[l] > 0){
                r--;
            } else{
                l++;
            }
        }
        System.out.println(min);
    }
}
