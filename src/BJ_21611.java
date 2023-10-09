import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_21611 {
    static int n;
    static int[][] map;
    static int[] answer = new int[4];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        seq = new int[n * n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map[n / 2][n / 2] = -1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            breakBall(d - 1, s);

            makeSeq();

            pullBall();

            while(true){

                boolean isExplode = explode();

                if(!isExplode) break;

                pullBall();
            }

            makeNewMap();
        }
        int result = answer[1] + (2 * answer[2]) + (3 * answer[3]);
        System.out.println(result);

    }

    static void breakBall(int d, int s){
        int x = n / 2;
        int y = n / 2;
        for (int i = 0; i < s; i++) {
            x = x + dx[d];
            y = y + dy[d];

            map[x][y] = 0;
        }
    }

    static void makeSeq(){

        int[] arrX = {1, 0, -1, 0};
        int[] arrY = {0, 1, 0, -1};

        int x = n / 2;
        int y = (n / 2) - 1;

        int len = 1;
        int dir = 0;
        seq[0][0] = x;
        seq[0][1] = y;

        int idx = 1;
        for (int i = 1; i <= n * 2 - 2; i++) {
            if(i % 2 == 0){
                len++;
            }

            for(int j = 0; j < len; j++){
                x = x + arrX[dir];
                y = y + arrY[dir];

                seq[idx][0] = x;
                seq[idx++][1] = y;
            }
            dir++;
            dir %= 4;
        }

    }


    static void pullBall(){

        for(int i = 0; i < n * n - 1; i++){
            int x = seq[i][0];
            int y = seq[i][1];

            if(map[x][y] == 0){
                for(int j = i + 1; j < n * n; j++){

                    if(j == n * n - 1){
                        map[x][y] = 0;
                        break;
                    }
                    if(map[seq[j][0]][seq[j][1]] != 0){
                        map[x][y] = map[seq[j][0]][seq[j][1]];
                        map[seq[j][0]][seq[j][1]] = 0;
                        break;
                    }

                }
            }
        }
    }

    static boolean explode() {
        int cnt = 1;
        int target = map[seq[0][0]][seq[0][1]];
        boolean isExplode = false;

        for(int i = 1; i < n * n - 1; i++){
            if(target == map[seq[i][0]][seq[i][1]]){
                cnt++;
            } else{
                if(cnt >= 4){
                    isExplode = true;
                    for(int j = 1; j <= cnt; j++){
                        map[seq[i -j][0]][seq[i - j][1]] = 0;
                    }
                    answer[target] += cnt;
                }
                target = map[seq[i][0]][seq[i][1]];
                cnt = 1;
            }
        }

        return isExplode;
    }

    static void makeNewMap(){
        int cnt = 1;
        int target = map[seq[0][0]][seq[0][1]];
        int idx = 0;

        int[][] newMap = new int[n][n];

        for (int i = 1; i < n * n - 1; i++) {
            if(map[seq[i][0]][seq[i][1]] == target){
                cnt++;
            } else{
                newMap[seq[idx][0]][seq[idx++][1]] = cnt;
                newMap[seq[idx][0]][seq[idx++][1]] = target;

                cnt = 1;
                target = map[seq[i][0]][seq[i][1]];
            }

            if(idx >= n * n - 1) break;
        }

        map = newMap;

    }

}
