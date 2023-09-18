import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17472 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
    static int[] parent;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.len - o2.len);
    static int[][] map;
    static class Node{
        int from;
        int to;
        int len;

        public Node(int from, int to, int len) {
            this.from = from;
            this.to = to;
            this.len = len;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j, cnt);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    func(i, j);
                }
            }
        }
        parent = new int[cnt];

        for (int i = 2; i < cnt; i++) {
            parent[i] = i;
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (find(node.from) != find(node.to)) {
                union(node.from, node.to);
                answer += node.len;
            }
        }

        int root = parent[2];
        for (int i = 3; i < cnt; i++) {
            if (find(parent[i]) != root) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(answer);

    }

    static void bfs(int x, int y, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        map[x][y] = num;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(map[nx][ny] == 1){
                        map[nx][ny] = num;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static void func(int x, int y) {

        Queue<int[]> q = new LinkedList<>();

        for (int d = 0; d < 4; d++) {
            q.add(new int[]{x, y, 0});

            while (!q.isEmpty()) {
                int[] now = q.poll();

                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(map[nx][ny] != map[x][y]){
                        if (map[nx][ny] == 0) {
                            q.add(new int[]{nx, ny, now[2] + 1});
                        } else {
                            if (now[2] > 1) {
                                pq.add(new Node(map[x][y], map[nx][ny], now[2]));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else{
            parent[x] = y;
        }


    }

    static int find(int x) {
        if(parent[x] == x) return x;

        return find(parent[x]);
    }
}
