import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_200056 {
    static int n;
    static List<Fire>[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static List<Fire> fireball = new ArrayList<>();
    static class Fire{
        int r;
        int c;
        int m;
        int s;
        int d;

        public Fire(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new ArrayList[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r - 1][c - 1].add(new Fire(r - 1, c - 1, w, s, d));
            fireball.add(new Fire(r - 1, c - 1, w, s, d));
        }

        for (int i = 0; i < k; i++) {
            func();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (Fire fire : map[i][j]) {
                    answer += fire.m;
                }
            }
        }

        System.out.println(answer);
    }

    static void func() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j].clear();
            }
        }
        int size = fireball.size();

        for (int i = 0; i < size; i++) {
            Fire fire = fireball.get(0);
            fireball.remove(0);

            int nx = (n + fire.r + (dx[fire.d] * (fire.s % n))) % n;
            int ny = (n + fire.c + (dy[fire.d] * (fire.s % n))) % n;

            Fire next = new Fire(nx, ny, fire.m, fire.s, fire.d);
            fireball.add(next);
            map[nx][ny].add(next);
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].size() > 1) {

                    divide(i, j);
                }
            }
        }
    }

    static void divide(int x, int y) {
        boolean isOdd = true;
        boolean isEven = true;
        int size = map[x][y].size();
        int avgM = 0;
        int avgS = 0;

        for (Fire fire : map[x][y]) {

            if (fire.d % 2 == 0) {
                isOdd = false;
            } else if (fire.d % 2 == 1) {
                isEven = false;
            }

            avgM += fire.m;
            avgS += fire.s;

            fireball.remove(fire);
        }

        map[x][y].clear();

        avgM /= 5;
        avgS /= size;

        if(avgM == 0) return;

        int d = 0;
        if (isOdd || isEven) {
            d = 0;
        } else {
            d = 1;
        }

        for (int i = d; i < 8; i += 2) {
            Fire next = new Fire(x, y, avgM, avgS, i);
            map[x][y].add(next);
            fireball.add(next);
        }

    }
}
