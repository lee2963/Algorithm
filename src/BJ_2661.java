import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2661 {
    static int n;
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String str = "";
        for (int i = 1; i <= 3; i++) {
            dfs(0, str + i);
        }

    }

    static void dfs(int cnt, String str) {

        if (answer != null) {
            return;
        }

        if (cnt == n - 1) {
            answer = str;
            System.out.println(answer);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (checkNum(str + i)) {
                dfs(cnt + 1, str + i);
            }
        }

    }

    static boolean checkNum(String str) {

        for (int i = 1; i <= str.length() / 2; i++) {
            for (int j = 0; j <= str.length() - (i * 2); j++) {
                if (str.substring(j, j + i).equals(str.substring(j + i, j + (i * 2)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
