import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3109 {
    static char[][] map;
    static int r, c;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static boolean[][] visited;
    static boolean flag;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            flag = false;
            dfs(i, 0);
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y) {
        if (y == c - 1) {
            answer++;
            flag = true;
            return;
        }


        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if(!visited[nx][ny] && map[nx][ny] != 'x') dfs(nx, ny);

                visited[nx][ny] = true;

                if(flag){
                    return;
                }
            }
        }
    }
}
