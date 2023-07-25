import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_12919 {
    static int flag = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();


        dfs(s, t);

        System.out.println(flag);
    }

    static void dfs(String s, String t) {

        if (s.length() == t.length()) {
            if (s.equals(t)) {
                flag = 1;
            }
            return;
        }

        if (t.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(t.substring(1));
            dfs(s, sb.reverse().toString());
        }

        if (t.charAt(t.length() - 1) == 'A') {
            dfs(s, t.substring(0, t.length() - 1));
        }
    }
}
