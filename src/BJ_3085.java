import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3085 {
    static int n;
    static char[][] map;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            checkCandyRow(i);
            checkCandyCol(i);
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i + 1 < n) {
                    if (map[i][j] != map[i + 1][j]) {
                        changeCandy(i, j, i + 1, j);

                        checkCandyRow(i);
                        checkCandyRow(i + 1);
                        checkCandyCol(j);

                        changeCandy(i, j, i + 1, j);
                    }
                }

                if (j + 1 < n) {
                    if (map[i][j] != map[i][j + 1]) {
                        changeCandy(i, j, i, j + 1);

                        checkCandyRow(i);
                        checkCandyCol(j);
                        checkCandyCol(j + 1);

                        changeCandy(i, j, i, j + 1);
                    }
                }
            }
        }

        System.out.println(max);

    }

    static void changeCandy(int x1, int y1, int x2, int y2) {

        char temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }

    static void checkCandyRow(int x) {
        int big = 1;
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (map[x][i] == map[x][i - 1]) {
                cnt++;
            } else{
                big = Math.max(cnt, big);
                cnt = 1;
            }
        }

        max = Math.max(max, Math.max(big, cnt));
    }

    static void checkCandyCol(int y) {
        int big = 1;
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (map[i][y] == map[i - 1][y]) {
                cnt++;
            } else{
                big = Math.max(cnt, big);
                cnt = 1;
            }
        }

        max = Math.max(max, Math.max(big, cnt));
    }

}
