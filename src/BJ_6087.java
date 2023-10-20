import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_6087 {
    static int r, c;
    static char[][] map;
    static int[][][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static Node start, end;
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;
        int dir;

        public Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        boolean flag = false;
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if(map[i][j] == 'C'){
                    if(!flag) {
                        start = new Node(i, j, 0, -1);
                        flag = true;
                    }
                    else end = new Node(i, j, 0, -1);
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Node> q = new PriorityQueue<>();
        visited = new int[4][r][c];
        q.add(start);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < r; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        while (!q.isEmpty()) {
            Node now = q.poll();

            if(now.x == end.x && now.y == end.y){
                return now.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == '*') continue;


                if(now.dir == -1 || now.dir == i){
                    if(visited[i][nx][ny] > now.cost) {
                        visited[i][nx][ny] = now.cost;
                        q.add(new Node(nx, ny, now.cost, i));
                    }
                } else {
                    if(visited[i][nx][ny] > now.cost + 1) {
                        visited[i][nx][ny] = now.cost + 1;
                        q.add(new Node(nx, ny, now.cost + 1, i));
                    }
                }
            }
        }
        return -1;
    }
}
