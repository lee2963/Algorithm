import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1194 {
    static int r, c;
    static char[][] map;
    static boolean[][][] visited;
    static class Node{
        int x;
        int y;
        int cnt;
        int key;

        public Node(int x, int y, int cnt, int key) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c][64];

        int[] start = new int[2];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();

            for(int j = 0; j < c; j++){
                if (map[i][j] == '0') {
                    start[0] = i;
                    start[1] = j;
                    map[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(start));

    }

    static int bfs(int[] start) {
        Queue<Node> q = new LinkedList<>();
        visited[start[0]][start[1]][0] = true;
        q.add(new Node(start[0], start[1], 0, 0));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (!q.isEmpty()) {
            Node now = q.poll();

            if(map[now.x][now.y] == '1'){
                return now.cnt;
            }

            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {

                    if(map[nx][ny] >= 'a'&& map[nx][ny] <= 'f'){
                        int key = 1 << map[nx][ny] - 'a';
                        int nextKey = key | now.key;

                        if(!visited[nx][ny][nextKey]){
                            visited[nx][ny][nextKey] = true;
                            q.add(new Node(nx, ny, now.cnt + 1, nextKey));
                        }
                    } else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F'){
                        int key = 1 << map[nx][ny] - 'A';
                        int chk = key & now.key;

                        if(chk > 0){
                            if(!visited[nx][ny][now.key]){
                                visited[nx][ny][now.key] = true;
                                q.add(new Node(nx, ny, now.cnt + 1, now.key));
                            }
                         }
                    } else if (map[nx][ny] == '.' || map[nx][ny] == '1') {
                        if(!visited[nx][ny][now.key]){
                            visited[nx][ny][now.key] = true;
                            q.add(new Node(nx, ny, now.cnt + 1, now.key));
                        }
                    }
                }
            }

        }
        return -1;
    }
}
