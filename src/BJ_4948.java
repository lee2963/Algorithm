import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] prime = new boolean[250000];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i < 250000; i++) {
            if(!prime[i]) {
                for (int j = i + i; j < 250000; j += i) {
                    prime[j] = true;
                }
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) return;

            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!prime[i]) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
