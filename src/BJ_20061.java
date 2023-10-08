import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20061 {
    static boolean[][] green;
    static boolean[][] blue;
    static int score = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        green = new boolean[6][4];
        blue = new boolean[4][6];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int state = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            moveGreen(x, y, state);
            moveBlue(x, y, state);
        }

        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if(green[i][j]) cnt++;

                if(blue[j][i]) cnt++;
            }
        }

        System.out.println(score);
        System.out.println(cnt);
    }

    static void moveGreen(int x, int y, int state) {


        if(state == 1){
            for (int i = 0; i <= 5; i++) {
                if(i == 5 || green[i + 1][y]){
                    green[i][y] = true;
                    break;
                }
            }
        } else if(state == 2){
            for (int i = 0; i <= 5; i++) {
                if(i == 5 || (green[i + 1][y] || green[i + 1][y + 1])){
                    green[i][y] = true;
                    green[i][y + 1] = true;

                    break;
                }
            }
        } else if(state == 3){
            for (int i = 0; i <= 5; i++) {
                if(i == 5 || green[i + 1][y]){
                    green[i][y] = true;
                    green[i - 1][y] = true;

                    break;
                }
            }
        }

        scoreGreen();
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j < 4; j++) {
                if(green[i][j]){
                    removeGreen(i);
                    break;
                }
            }
        }


    }

    static void moveBlue(int x, int y, int state) {

        if(state == 1){
            for (int i = 0; i <= 5; i++) {
                if(i == 5 || blue[x][i + 1]){
                    blue[x][i] = true;
                    break;
                }
            }
        } else if(state == 2){
            for (int i = 0; i <= 5; i++) {
                if(i == 5 || blue[x][i + 1]){
                    blue[x][i] = true;
                    blue[x][i - 1] = true;
                    break;
                }
            }

        } else if(state == 3){
            for (int i = 0; i <= 5; i++) {
                if(i == 5 || (blue[x][i + 1] || blue[x + 1][i + 1])){
                    blue[x][i] = true;
                    blue[x + 1][i] = true;
                    break;
                }
            }
        }
        scoreBlue();
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j < 4; j++) {
                if(blue[j][i]){
                    removeBlue(i);
                    break;
                }
            }
        }

    }

    static void removeGreen(int remove) {

        if(remove == 0){
            for (int i = 5; i >= 2; i--) {
                for (int j = 0; j < 4; j++) {
                    green[i][j] = green[i - 2][j];
                }
            }

            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j < 4; j++) {
                    green[i][j] = false;
                }
            }
        } else {
            for (int i = 5; i >= 1; i--) {
                for (int j = 0; j < 4; j++) {
                    green[i][j] = green[i - 1][j];
                }
            }

            for (int j = 0; j < 4; j++) {
                    green[1][j] = false;
            }
        }
    }

    static void removeBlue(int remove) {
        if(remove == 0){
            for (int i = 5; i >= 2; i--) {
                for (int j = 0; j < 4; j++) {
                    blue[j][i] = blue[j][i - 2];
                }
            }

            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j < 4; j++) {
                    blue[j][i] = false;
                }
            }
        } else {
            for (int i = 5; i >= 1; i--) {
                for (int j = 0; j < 4; j++) {
                    blue[j][i] = blue[j][i - 1];
                }
            }

            for (int j = 0; j < 4; j++) {
                blue[j][1] = false;
            }
        }
    }

    static void scoreGreen() {
        for (int i = 0; i <= 5; i++) {
            int greenCnt = 0;
            for (int j = 0; j < 4; j++) {
                if (green[i][j]) greenCnt++;
            }

            if (greenCnt == 4) {
                for (int j = 0; j < 4; j++) {
                    green[i][j] = false;
                }

                for (int j = i; j >= 1; j--) {
                    for (int k = 0; k < 4; k++) {
                        green[j][k] = green[j - 1][k];
                    }
                }

                for (int j = 0; j < 4; j++) {
                    green[0][j] = false;
                }
                score++;
            }


        }
    }

    static void scoreBlue() {
        for (int i = 0; i <= 5; i++) {
            int blueCnt = 0;

            for (int j = 0; j < 4; j++) {
                if (blue[j][i]) blueCnt++;
            }


            if (blueCnt == 4) {
                for (int j = 0; j < 4; j++) {
                    blue[j][i] = false;
                }

                for (int j = i; j >= 1; j--) {
                    for (int k = 0; k < 4; k++) {
                        blue[k][j] = blue[k][j - 1];
                    }
                }

                for (int j = 0; j < 4; j++) {
                    green[j][0] = false;
                }
                score++;
            }
        }

    }
}
