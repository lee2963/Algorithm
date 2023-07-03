import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2116 {
    static int[][] arr;
    static int[] op = {5, 3, 4, 1, 2, 0};
    static int n;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][6];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 6; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 6; i++) {
            int max = 0;
            for (int j = 0; j < 6; j++) {
                if (j == i || j == op[i]) continue;

                max = Math.max(max, arr[0][j]);
            }

            dfs(1, arr[0][op[i]], max);
        }

        System.out.println(answer);
    }

    static void dfs(int cnt, int value, int sum) {
        if (cnt == n) {
            answer = Math.max(sum, answer);
            return;
        }

        int index = 0;
        for (int i = 0; i < 6; i++) {
            if(arr[cnt][i] == value){
                index = i;
                break;
            }
        }
        int max = 0;
        for (int i = 0; i < 6; i++) {
            if (i == index || i == op[index]) continue;

            max = Math.max(max, arr[cnt][i]);

        }
        dfs(cnt + 1, arr[cnt][op[index]], max + sum);
    }
}
