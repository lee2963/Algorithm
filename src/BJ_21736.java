import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_21736 {
    static int r, c;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        int[] start = new int[2];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        int answer = bfs(start);

        if (answer == 0) {
            System.out.println("TT");
            return;
        }
        System.out.println(answer);

    }

    static int bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);

        boolean[][] visited = new boolean[r][c];
        visited[start[0]][start[1]] = true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if(!visited[nx][ny]){

                        if(map[nx][ny] == 'X') continue;

                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});

                        if(map[nx][ny] == 'P'){
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
