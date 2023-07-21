import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888 {
    static int n;
    static int[] num;
    static int[] operation;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        operation = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }


        dfs(1, 0, 0, 0, 0, num[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int cnt, int add, int subtract, int multiply, int divide, int value) {

        if (cnt == n) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        if (add < operation[0]) {
            dfs(cnt + 1, add + 1, subtract, multiply, divide, value + num[cnt]);
        }

        if (subtract < operation[1]) {
            dfs(cnt + 1, add, subtract + 1, multiply, divide, value - num[cnt]);
        }

        if (multiply < operation[2]) {
            dfs(cnt + 1, add, subtract, multiply + 1, divide, value * num[cnt]);
        }

        if (divide < operation[3]) {
            dfs(cnt + 1, add, subtract, multiply, divide + 1, value / num[cnt]);
        }
    }
}
