import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        Arrays.sort(str, ((o1, o2) -> o1.length() - o2.length()));

        int answer =0 ;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = i + 1; j < n; j++) {
                if (str[i].equals(str[j].substring(0, str[i].length()))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
