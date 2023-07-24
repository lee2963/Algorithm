import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String target = br.readLine();
        int[] alpha = new int[26];
        int answer = 0;
        int len = target.length();

        for (int i = 0; i < target.length(); i++) {
            alpha[target.charAt(i) - 'A']++;
        }

        for (int i = 1; i < n; i++) {
            String str = br.readLine();
            int[] tmp = alpha.clone();
            int cnt = 0;

            if(Math.abs(str.length() - len) > 1) continue;

            for (int j = 0; j < str.length(); j++) {
                int idx = str.charAt(j) - 'A';
                if (tmp[idx] > 0) {
                    cnt++;
                    tmp[idx]--;
                }
            }

                if (len == str.length()) {
                    if(cnt == len) answer++;
                    else if(cnt == len - 1) answer++;

                } else if (len + 1 == str.length()) {
                    if(cnt == len) answer++;

                } else if (len - 1 == str.length()) {
                    if(cnt == len - 1) answer++;
                }

        }
        System.out.println(answer);

    }
}
