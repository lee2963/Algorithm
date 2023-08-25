import java.io.*;
import java.util.*;

class Goorm_10 {
    static int[] dx = {-1, 1, 0, 0}; //위 아래 오 왼
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static String[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int goormX = Integer.parseInt(st.nextToken()) - 1;
        int goormY = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int playerX = Integer.parseInt(st.nextToken()) - 1;
        int playerY = Integer.parseInt(st.nextToken()) - 1;

        map = new String[n][n];
        for(int i = 0; i < n; i++){
            map[i] = br.readLine().split(" ");
        }

        int goorm = playGame(goormX, goormY);
        int player = playGame(playerX, playerY);

        if(goorm > player){
            System.out.print("goorm " + goorm );
            return;
        }
        System.out.print("player " + player);
    }

    static int playGame(int x, int y){

        boolean[][] visited = new boolean[n][n];
        visited[x][y] = true;
        int point = 1;

        while(true){
            char dir = map[x][y].charAt(map[x][y].length() - 1);
            int move = Integer.parseInt(map[x][y].substring(0, map[x][y].length() - 1));
            boolean flag = true;

            int d = 0;
            if(dir == 'U'){
                d = 0;
            } else if(dir == 'D'){
                d = 1;
            } else if(dir == 'R'){
                d = 2;
            } else if(dir == 'L'){
                d = 3;
            }

            for(int i = 0; i < move; i++){
                x = (x + dx[d]) % n;
                y = (y + dy[d]) % n;

                if(x == -1) x = n - 1;
                if(y == -1) y = n - 1;
                if(!visited[x][y]){
                    point++;
                    visited[x][y] = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
        }
        return point;
    }
}