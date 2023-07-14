import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[][] alpha = new int[26][str.length() + 1];


        for (int i = 1; i <= str.length(); i++) {
            char target = str.charAt(i - 1);

            alpha[target - 'a'][i]++;

            for (int j = 0; j < 26; j++) {
                alpha[j][i] += alpha[j][i - 1];
            }
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            char ch = input[0].charAt(0);
            int start = Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[2]);

            sb.append(alpha[ch - 'a'][end + 1] - alpha[ch - 'a'][start]).append("\n");
        }
        System.out.println(sb);
    }
}
