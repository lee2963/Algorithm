import java.io.*;
import java.util.*;

class Goorm_9 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][n];
        int[][] result = new int[n][n];
        int answer = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        int[] dx = {0, 0, 1, 0, -1};
        int[] dy = {0, 1, 0, -1, 0};

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for(int j = 0; j < 5; j++){
                int nx = x + dx[j];
                int ny = y + dy[j];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if(map[nx][ny] == '#') continue;
                    else if(map[nx][ny] == '@') result[nx][ny] += 2;
                    else result[nx][ny] += 1;

                    answer = Math.max(result[nx][ny], answer);
                }
            }
        }

        System.out.println(answer);
    }
}