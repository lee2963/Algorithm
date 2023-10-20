import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] rDp = new int[n];
        int[] lDp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        rDp[0] = 1;
        for (int i = 1; i < n; i++) {
            rDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    rDp[i] = Math.max(rDp[j] + 1, rDp[i]);
                }
            }
        }

        lDp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            lDp[i] = 1;
            for (int j = n - 1; j >= i; j--) {
                if(arr[j] < arr[i]){
                    lDp[i] = Math.max(lDp[j] + 1, lDp[i]);
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            answer = Math.max(answer, rDp[i] + lDp[i]);
        }

        System.out.println(answer - 1);


    }
}
