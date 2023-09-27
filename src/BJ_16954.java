import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_16954 {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[8][8];
        for (int i = 0; i < 8; i++) {
            map[i] = br.readLine().toCharArray();
        }


        if (bfs()) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {7, 0});
        boolean[][] visited;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1, 0};

        while (!q.isEmpty()) {
            int size = q.size();
            visited = new boolean[8][8];

            for (int i = 0; i < size; i++) {
                int[] now = q.poll();

                if(map[now[0]][now[1]] == '#') continue;

                if (now[0] == 0 && now[1] == 7) {
                    return true;
                }

                for (int j = 0; j < 9; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < 8 && ny < 8) {
                        if(!visited[nx][ny] && map[nx][ny] == '.'){
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            wallDown();
        }
        return false;
    }

    static void wallDown() {
        for (int i = 7; i > 0; i--) {
            for (int j = 0; j < 8; j++) {
                if(map[i][j] == '#') map[i][j] = '.';

                if(map[i -1][j] =='#') map[i][j] = '#';
            }
        }

        for (int i = 0; i < 8; i++) {
            map[0][i] = '.';
        }
    }
}