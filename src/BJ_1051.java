import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int max = 1;

        int[][] map = new int[r][c];

        for (int i = 0; i < r; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = ch[j] - '0';
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int min = Math.min(r - i, c - j);
                for (int k = 1; k < min; k++) {
                    if (map[i][j] == map[i + k][j] && map[i + k][j] == map[i][j + k] && map[i][j + k] == map[i + k][j + k]) {
                        max = Math.max((k + 1) *(k + 1), max);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
