import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_22857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = 0;
        int even = 0, odd = 0;

        if(arr[0] % 2 == 0) even++;
        else odd++;

        int max = 0;

        while(r < n){
            max = Math.max(max, even);
            if(odd > k){
                if(arr[l] % 2 != 0){
                    odd--;
                } else{
                    even--;
                }
                l++;
            } else{
                r++;
                if(r >= n) break;

                if(arr[r] % 2 != 0){
                    odd++;
                } else {
                    even++;
                }
            }
        }
        System.out.println(max);

    }
}
