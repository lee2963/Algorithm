import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_17837 {
    static int n, k;
    static int[][] map;
    static List<Integer>[][] list;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Map<Integer, Horse> point;
    static class Horse{
        int x;
        int y;
        int dir;

        public Horse(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        list = new ArrayList[n][n];
        point = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                list[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            point.put(i + 1, new Horse(x, y, d));
            list[x][y].add(i + 1);
        }

        int cnt = 1;
        while (cnt <= 1000) {

            for (int i = 1; i <= k; i++) {
                Horse now = point.get(i);

                List<Integer> up = new ArrayList<>();
                int start = 0;
                for (int j = 0; j < list[now.x][now.y].size(); j++) {
                    if (list[now.x][now.y].get(j) == i) {
                        start = j;
                        break;
                    }
                }

                for (int j = start; j < list[now.x][now.y].size(); j++) {
                    up.add(list[now.x][now.y].get(j));
                }

                for (int j = list[now.x][now.y].size() - 1; j >= start; j--) {
                    list[now.x][now.y].remove(j);
                }

                int nx = now.x + dx[now.dir];
                int ny = now.y + dy[now.dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == 2) {
                    nx -= dx[now.dir];
                    ny -= dy[now.dir];

                    if ((now.dir + 1) % 2 == 0) {
                        now.dir--;
                    } else {
                        now.dir++;
                    }

                    nx += dx[now.dir];
                    ny += dy[now.dir];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == 2) {
                        nx -= dx[now.dir];
                        ny -= dy[now.dir];
                        point.put(up.get(0), new Horse(nx, ny, now.dir));

                        for (Integer integer : up) {
                            list[now.x][now.y].add(integer);
                        }
                    } else{
                        if(map[nx][ny] == 1){
                            for (int j = up.size() - 1; j >= 0; j--) {
                                list[nx][ny].add(up.get(j));
                                Horse horse = point.get(up.get(j));
                                point.put(up.get(j), new Horse(nx, ny, horse.dir));
                            }

                        } else if(map[nx][ny] == 0){
                            for (int j = 0; j < up.size(); j++) {
                                list[nx][ny].add(up.get(j));
                                Horse horse = point.get(up.get(j));
                                point.put(up.get(j), new Horse(nx, ny, horse.dir));
                            }
                        }
                    }
                } else if(map[nx][ny] == 1){
                    for (int j = up.size() - 1; j >= 0; j--) {
                        list[nx][ny].add(up.get(j));
                        Horse horse = point.get(up.get(j));
                        point.put(up.get(j), new Horse(nx, ny, horse.dir));
                    }
                } else if(map[nx][ny] == 0){
                    for (int j = 0; j < up.size(); j++) {
                        list[nx][ny].add(up.get(j));
                        Horse horse = point.get(up.get(j));
                        point.put(up.get(j), new Horse(nx, ny, horse.dir));
                    }
                }

                if (list[nx][ny].size() >= 4) {
                    System.out.println(cnt);
                    return;
                }
            }

            cnt++;
        }

        System.out.println(-1);
    }
}
