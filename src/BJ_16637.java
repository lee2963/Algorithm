import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16637 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = Integer.MAX_VALUE;
    static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int num = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (map[i][j] == 1) {
                    divideIsland(i, j, num);
                    num++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] != 0){
                    visited = new boolean[n][n];
                    bfs(i, j);
                }
            }
        }
        System.out.println(answer);


    }

    static void divideIsland(int x, int y, int num) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        map[x][y] = num;


        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(map[nx][ny] == 1){
                        map[nx][ny] = num;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, cur.cnt + 1));
                    } else if (!visited[nx][ny] && map[nx][ny] != map[x][y]) {
                        answer = Math.min(answer, cur.cnt);
                    }
                }

            }
        }
    }
}
