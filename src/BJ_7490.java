import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_7490 {
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            len = Integer.parseInt(br.readLine());
            dfs(1, 1, 0, 1, "1");
            System.out.println();
        }
    }

    static void dfs(int cnt,int num,  int sum, int op, String str) {

        if (cnt == len) {
            sum += (num * op);

            if (sum == 0) {
                System.out.println(str);
            }
            return;
        }

        dfs(cnt + 1, (num * 10) + (cnt + 1) , sum, op, str + " " + (cnt + 1));
        dfs(cnt + 1, cnt + 1, sum + (num * op), 1,str + "+" + (cnt + 1));
        dfs(cnt + 1, cnt + 1, sum + (num * op), -1,  str + "-" + (cnt + 1));


    }
}
