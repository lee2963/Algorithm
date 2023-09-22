import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_6443 {
    static int[] chars;
    static StringBuilder answer;
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char[] ch = br.readLine().toCharArray();
            chars = new int[26];
            len = ch.length;

            for (int j = 0; j < ch.length; j++) {
                chars[ch[j] - 'a']++;
            }

            dfs("", 0);

        }

        System.out.println(answer);
    }

    static void dfs(String str, int cnt) {

        if (cnt == len) {
            answer.append(str).append("\n");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (chars[i] > 0) {
                chars[i]--;
                dfs(str + (char) (i+'a'), cnt + 1);
                chars[i]++;
            }
        }

    }
}
