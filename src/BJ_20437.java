import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String input = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if(k == 1){
                System.out.println(1 + " " + 1);
                continue;
            }

            int[] alpha = new int[26];

            for (int j = 0; j < input.length(); j++) {
                int idx = input.charAt(j) - 'a';
                alpha[idx]++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < input.length(); j++) {
                char target = input.charAt(j);
                if (alpha[target - 'a'] >= k) {
                    int cnt = 1;
                    for (int m = j + 1; m < input.length(); m++) {
                        if(input.charAt(m) == target) cnt++;

                        if (cnt == k) {
                            min = Math.min(min, m - j + 1);
                            max = Math.max(max, m - j + 1);
                            break;
                        }
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                System.out.println(-1);
            }else {
                System.out.println(min + " " + max);
            }
        }
    }
}
