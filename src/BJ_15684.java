import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15684  {
    static int n, m, h;
    static boolean[][] ladder;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        ladder = new boolean[h][n];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            ladder[a][b] = true;
        }

        makeBridge(0);

        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(min);

    }

    static void makeBridge(int cnt) {

        if(check()) min = Math.min(min, cnt);

        if (cnt == 3) return;

        for(int i = 0; i < h; i++){
            for (int j = 0; j < n - 1; j++) {
                if(!ladder[i][j]){
                    ladder[i][j] = true;
                    makeBridge(cnt + 1);
                    ladder[i][j] = false;
                }
            }
        }
    }

    static boolean check() {

        for (int i = 0; i < n; i++) {
            int c = i;

            for(int j = 0; j < h; j++){
                if(c > 0 && ladder[j][c - 1]) {
                    c = c - 1;
                } else if (ladder[j][c]) {
                    c = c + 1;
                }
            }
            if(c != i){
                return false;
            }
        }
        return true;
    }
}
