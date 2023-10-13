
import java.io.*;
import java.util.*;

public class CodeTree_potop {
    static int n, m, k;
    static int[][] map;
    static int[] attack;
    static int[] victim;
    static int[][] recentAttack;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] fix;
    static class Node{
        int x;
        int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        attack = new int[2];
        victim = new int[2];
        recentAttack = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int t = 0; t < k; t++) {

            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] > 0) cnt++;
                }
            }

            if(cnt == 1) break;
            fix = new boolean[n][m];
            findAttack();
            recentAttack[attack[0]][attack[1]] = t + 1;
            findVictim();

            if(!razerRoute()) {
                potopAttack();
            }

            potopFix();
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                answer = Math.max(map[i][j], answer);
            }
        }
        System.out.println(answer);
    }

    static void findAttack() {
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != 0 && map[i][j] <= min) {
                    if(map[i][j] < min) {
                        attack[0] = i;
                        attack[1] = j;
                        min = map[i][j];
                    } else if(map[i][j] == min) {
                        if(recentAttack[i][j] > recentAttack[attack[0]][attack[1]]) {
                            attack[0] = i;
                            attack[1] = j;
                        } else if(recentAttack[i][j] == recentAttack[attack[0]][attack[1]]) {
                            if((i + j )> (attack[0] + attack[1])) {
                                attack[0] = i;
                                attack[1] = j;
                            } else if((i + j ) == (attack[0] + attack[1])) {
                                if(j > attack[1]) {
                                    attack[0] = i;
                                    attack[1] = j;
                                }
                            }
                        }
                    }
                }
            }
        }

        map[attack[0]][attack[1]] += n + m;
        fix[attack[0]][attack[1]] = true;
    }

    static void findVictim() {
        int max = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!(i == attack[0] && j == attack[1]) && map[i][j] >= max) {
                    if(map[i][j] > max) {
                        victim[0] = i;
                        victim[1] = j;
                        max = map[i][j];
                    } else if(map[i][j] == max) {
                        if(recentAttack[i][j] < recentAttack[victim[0]][victim[1]]) {
                            victim[0] = i;
                            victim[1] = j;
                        } else if(recentAttack[i][j] == recentAttack[victim[0]][victim[1]]) {
                            if((i + j) < (victim[0] + victim[1])) {
                                victim[0] = i;
                                victim[1] = j;
                            } else if((i + j) == (victim[0] + victim[1])) {
                                if(j < victim[1]) {
                                    victim[0] = i;
                                    victim[1] = j;
                                }
                            }
                        }
                    }
                }
            }
        }
        fix[victim[0]][victim[1]] = true;
    }

    static boolean razerRoute() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {attack[0], attack[1], 0});
        boolean[][] visited = new boolean[n][m];
        visited[attack[0]][attack[1]] = true;

        Node[][] route = new Node[n][m];

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == victim[0] && now[1] == victim[1]) {
                razerAttack(route, now[2]);
                return true;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx < 0) nx = n - 1;
                if(ny < 0) ny = m - 1;
                if(nx >= n) nx = 0;
                if(ny >= m) ny = 0;

                if(!visited[nx][ny] && map[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    route[nx][ny] = new Node(now[0], now[1]);
                    q.add(new int[] {nx, ny, now[2] + 1});
                }

            }
        }

        return false;

    }

    static void razerAttack(Node[][] route, int size) {

        int attackPoint = map[attack[0]][attack[1]];
        map[victim[0]][victim[1]] -= attackPoint;
        if(map[victim[0]][victim[1]] < 0) map[victim[0]][victim[1]] = 0;
        int[] now = {victim[0], victim[1]};

        for(int i = 0; i < size - 1; i++) {
            Node next = route[now[0]][now[1]];
            fix[next.x][next.y] = true;

            map[next.x][next.y] -= (attackPoint / 2);

            if(map[next.x][next.y] < 0) map[next.x][next.y] = 0;

            now[0] = next.x;
            now[1] = next.y;
        }
    }

    static void potopAttack() {
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1};

        int attackPoint = map[attack[0]][attack[1]];
        map[victim[0]][victim[1]] -= attackPoint;
        if(map[victim[0]][victim[1]] < 0) map[victim[0]][victim[1]] = 0;

        for(int i = 0; i < 8; i++) {
            int nx = victim[0] + dx[i];
            int ny = victim[1] + dy[i];

            if(nx < 0) nx = n -1;
            if(ny < 0) ny = m - 1;
            if(nx >= n) nx = 0;
            if(ny >= m) ny = 0;

            if(map[nx][ny] != 0 && !(nx == attack[0] && ny == attack[1])) {
                map[nx][ny] -= attackPoint / 2;
                fix[nx][ny] = true;

                if(map[nx][ny] < 0) map[nx][ny] = 0;
            }
        }
    }

    static void potopFix() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!fix[i][j] && map[i][j] != 0) {
                    map[i][j]++;
                }
            }
        }
    }
}
