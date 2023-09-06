import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_10164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        int r = 0;
        int c = 0;
        int cnt = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0) {
                    map[i][j] = 1;
                } else{
                    map[i][j] = map[i][j - 1] + map[i - 1][j];
                }

                if(cnt == num){
                    r = i;
                    c = j;
                }
                cnt++;
            }
        }

        System.out.println(map[r][c] * map[n - r - 1][m - c - 1]);
    }
}
