import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17136 {
    static int[][] map;
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static final int n = 10;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0 ,0 , 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y, int cnt){

        if (x == 10 && y == 0) {
            answer = Math.min(answer, cnt);
            return;
        }

        if(cnt > answer){
            return;
        }

        if(y == 10){
            dfs(x + 1, 0, cnt);
            return;
        }

        if(map[x][y] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (paper[i] > 0 && isPossible(x, y, i)){
                    attach(x, y, i, 0);
                    paper[i]--;
                    dfs(x, y, cnt + 1);
                    attach(x, y, i, 1);
                    paper[i]++;
                }
            }
        } else{
            dfs(x, y + 1, cnt);
        }

    }

    static boolean isPossible(int x, int y, int size) {

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(i >= 10 || j >= 10) return false;

                if(map[i][j] == 0) return false;
            }
        }

        return true;
    }

    static void attach(int x, int y, int size, int num) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = num;
            }
        }
    }
}
