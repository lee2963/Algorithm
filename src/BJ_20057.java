import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20057 {
    static int n;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1}; //좌 하 우 상
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                answer += map[i][j];
            }
        }

        int len = 0 ;
        int dir = 0;
        int x = n / 2;
        int y = n / 2;
        for (int i = 1; i <= n * 2 - 1; i++) {
            if( i % 2 != 0 && i != n * 2 - 1) len++;

            for (int j = 0; j < len; j++) {
                x = x + dx[dir];
                y = y + dy[dir];
                moveWind(x, y, dir);
            }
            dir++;
            dir %= 4;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer -= map[i][j];
            }
        }

        System.out.println(answer);
    }

    static void moveWind(int x, int y, int dir) {

        if (dir == 0) {
            moveSandLeft(x, y);
        } else if(dir == 1) {
            moveSandDown(x, y);
        } else if (dir == 2) {
            moveSandRight(x, y);
        } else if (dir == 3) {
            moveSandUp(x, y);
        }
    }

    static void moveSandLeft(int x, int y) {

        int[] sandX = {-2, -1, -1, -1, 0, 1, 1, 1, 2, 0};
        int[] sandY = {0, 1, 0, -1, -2, 1, 0, -1, 0, -1};
        double[] percent = {0.02, 0.01, 0.07, 0.1, 0.05, 0.01, 0.07, 0.1, 0.02};

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int nx = x + sandX[i];
            int ny = y + sandY[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if(i == 9){
                    map[nx][ny] += (map[x][y] - sum);

                } else{
                    map[nx][ny] += (int) (map[x][y] * percent[i]);
                    sum += (int) (map[x][y] * percent[i]);
                }
            } else{
                if(i != 9) sum += (int) (map[x][y] * percent[i]);
            }
        }

        map[x][y] = 0;
    }

    static void moveSandDown(int x, int y) {
        int[] sandX = {0, -1, 0, 1, 2, -1, 0, 1, 0, 1};
        int[] sandY = {2, 1, 1, 1, 0, -1, -1, -1, -2, 0};
        double[] percent = {0.02, 0.01, 0.07, 0.1, 0.05, 0.01, 0.07, 0.1, 0.02};

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int nx = x + sandX[i];
            int ny = y + sandY[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if(i == 9){
                    map[nx][ny] += (map[x][y] - sum);

                } else{
                    map[nx][ny] += (int) (map[x][y] * percent[i]);
                    sum += (int) (map[x][y] * percent[i]);
                }
            } else{
                if(i != 9) sum += (int) (map[x][y] * percent[i]);
            }
        }

        map[x][y] = 0;
    }

    static void moveSandRight(int x, int y) {
        int[] sandX = {-2, -1, -1, -1, 0, 1, 1, 1, 2, 0};
        int[] sandY = {0, -1, 0, 1, 2, -1, 0, 1, 0, 1};
        double[] percent = {0.02, 0.01, 0.07, 0.1, 0.05, 0.01, 0.07, 0.1, 0.02};

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int nx = x + sandX[i];
            int ny = y + sandY[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if(i == 9){
                    map[nx][ny] += (map[x][y] - sum);
                } else{
                    map[nx][ny] += (int) (map[x][y] * percent[i]);
                    sum += (int) (map[x][y] * percent[i]);
                }
            } else{
                if(i != 9) sum += (int) (map[x][y] * percent[i]);
            }
        }

        map[x][y] = 0;
    }

    static void moveSandUp(int x, int y) {
        int[] sandX = {0, 1, 0, -1, -2, 1, 0, -1, 0, -1};
        int[] sandY = {2, 1, 1, 1, 0, -1, -1, -1, -2, 0};
        double[] percent = {0.02, 0.01, 0.07, 0.1, 0.05, 0.01, 0.07, 0.1, 0.02};

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int nx = x + sandX[i];
            int ny = y + sandY[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if(i == 9){
                    map[nx][ny] += (map[x][y] - sum);
                } else{
                    map[nx][ny] += (int) (map[x][y] * percent[i]);
                    sum += (int) (map[x][y] * percent[i]);
                }
            } else {
                if(i != 9) sum += (int) (map[x][y] * percent[i]);
            }
        }

        map[x][y] = 0;
    }
}
