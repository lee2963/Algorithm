import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_13413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            String origin = br.readLine();
            String target = br.readLine();

            int black = 0;
            int white = 0;

            for (int j = 0; j < origin.length(); j++) {
                char cur = origin.charAt(j);
                if (cur != target.charAt(j)) {
                    if (cur == 'B') {
                        black++;
                    } else {
                        white++;
                    }
                }
            }

            System.out.println(Math.max(black, white));
        }
    }
}
