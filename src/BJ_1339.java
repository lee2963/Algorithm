import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] str = new String[n];
        int[] aph = new int[26];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            int tmp = (int) Math.pow(10, str[i].length() - 1);
            for (int j = 0; j < str[i].length(); j++) {
                int idx = str[i].charAt(j) - 'A';
                aph[idx] += tmp;
                tmp /= 10;
            }
        }

        Arrays.sort(aph);

        int sum = 0;
        int idx = 9;
        for (int i = 25; i >= 0; i--) {
            if(aph[i] == 0) break;

            sum += aph[i] * idx;
            idx--;
        }
        System.out.println(sum);
    }
}
