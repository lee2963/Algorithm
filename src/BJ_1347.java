import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[101][101];

        for (int i = 0; i < 101; i++) {
            Arrays.fill(map[i], '#');
        }

        int x, y, minX, minY, maxX, maxY;
        x = y = minX = minY = maxX = maxY = 50;

        String s = br.readLine();

        int[] dx = {0, 1, 0, -1}; //좌 하 우 상
        int[] dy = {1, 0, -1, 0};

        int dir = 1;
        map[x][y] = '.';
        for (int i = 0; i < s.length(); i++) {
            char move = s.charAt(i);

            if (move == 'F') {
                x = x + dx[dir];
                y = y + dy[dir];

                map[x][y] = '.';

                maxX = Math.max(x, maxX);
                minX = Math.min(x, minX);
                maxY = Math.max(y, maxY);
                minY = Math.min(y, minY);

            } else if (move == 'R') {
                dir++;
                if(dir == 4) dir = 0;
            } else if (move == 'L') {
                dir--;
                if (dir == -1) {
                    dir = 3;
                }
            }
        }

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
