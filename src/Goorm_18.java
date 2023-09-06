import java.io.*;
import java.util.*;

class Goorm_18 {
    static int n;
    static int[][] row;
    static int[][] col;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        row = new int[n + 1][n + 1];
        col = new int[n + 1][n + 1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            if(d == 'U'){
                up(r, c);
            } else if(d == 'D'){
                down(r, c);
            } else if(d == 'L'){
                left(r, c);
            } else if(d == 'R'){
                right(r, c);
            }
        }

        long answer = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                answer += (long) row[i][j] * col[i][j];
            }
        }

        System.out.println(answer);
    }

    static void up(int x, int y){
        for(int i = x; i >= 1; i--){
            col[i][y] += 1;
        }
    }

    static void down(int x, int y){
        for(int i = x; i <= n; i++){
            col[i][y] += 1;
        }
    }

    static void right(int x, int y){
        for(int i = y; i <= n; i++){
            row[x][i] += 1;
        }
    }

    static void left(int x, int y){
        for(int i = y; i >= 1; i--){
            row[x][i] += 1;
        }
    }
}