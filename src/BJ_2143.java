import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        long[] aAvg = new long[n * (n + 1) / 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        for(int i = 0; i < n; i++){
            long val = 0;
            for (int j = i; j < n; j++) {
                val += a[j];
                aAvg[idx++] = val;
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        long[] bAvg = new long[m * ( m + 1) / 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        idx = 0;
        for(int i = 0; i < m; i++){
            long val = 0;
            for (int j = i; j < m; j++) {
                val += b[j];
                bAvg[idx++] = val;
            }
        }

        Arrays.sort(aAvg);
        Arrays.sort(bAvg);

        int left = 0;
        int right = bAvg.length - 1;

        long answer = 0;
        while (left < aAvg.length && right >= 0) {
            long av = aAvg[left], bv = bAvg[right];
            long now = av + bv;
            if(now == t) {
                long ac =0, bc =0;
                while(left< aAvg.length && av == aAvg[left]) {
                    left++;
                    ac++;
                }

                while(right>= 0 && bv == bAvg[right]) {
                    right--;
                    bc++;
                }
                answer += ac*bc;
            } else if( now > t){
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer);
    }
}
