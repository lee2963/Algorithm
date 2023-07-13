import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        char[] a = input[0].toCharArray();
        char[] b = input[1].toCharArray();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= b.length - a.length; i++) {
            int cnt = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j] != b[i + j]) {
                    cnt++;
                }
            }
            answer = Math.min(cnt, answer);
        }

        System.out.println(answer);
    }
}
