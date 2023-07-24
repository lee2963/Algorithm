import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] ch = new char[len];
            for (int j = 0; j < len; j++) {
                ch[j] = st.nextToken().charAt(0);
            }

            StringBuilder answer = new StringBuilder();
            answer.append(ch[0]);
            for (int j = 1; j < len; j++) {
                if (ch[j] <= answer.charAt(0)) {
                    answer.insert(0, ch[j]);
                } else{
                    answer.append(ch[j]);
                }
            }
            System.out.println(answer);
        }
    }
}
