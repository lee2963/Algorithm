import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long [] f = new long[21];
        boolean [] c = new boolean[21];
        Arrays.fill(f, 1);

        for(int i=1; i<=20; i++) {
            f[i] = f[i-1]*i;
        }

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int problem = Integer.parseInt(st.nextToken());

        int [] a = new int[n];
        if(problem == 2) {
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < a[i]; j++) {
                    if (!c[j])
                        ans += f[n - i - 1];
                }
                c[a[i]] = true;
            }
            System.out.println(ans);
        }
        else if(problem == 1) {
            long k = Long.parseLong(st.nextToken());

            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (c[j]) continue;

                    if (f[n - i - 1] < k) {
                        k -= f[n - i - 1];
                    } else {
                        a[i] = j;
                        c[j] = true;
                        break;
                    }
                }
            }
            for(int i=0; i<n; i++) {
                System.out.print(a[i] + " ");
            }
        }
    }
}
