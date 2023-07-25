import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        int answer = Integer.MAX_VALUE;
        int answerBlock = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }
        for (int i = min; i <= max; i++) {
            int block = b;
            int time = 0;
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {

                    if (map[j][k] > i) {
                        block += map[j][k] - i;
                        time += (map[j][k] - i) * 2;

                    } else {
                        block -= i - map[j][k];
                        time += i - map[j][k];
                    }
                }
            }
            if (block < 0) {
                time = Integer.MAX_VALUE;
                break;
            }

            if (time <= answer) {
                answer = time;
                answerBlock = i;
            }
        }

        System.out.println(answer +" " + answerBlock);
    }
}
