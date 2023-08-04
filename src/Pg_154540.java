import java.util.*;

public class Pg_154540 {
    static List<Integer> list = new ArrayList<>();
    static char[][] map;
    static boolean[][] visited;
    static int r, c;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int[] solution(String[] maps) {
        r = maps.length;
        c = maps[0].length();

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] != 'X') {
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        if (list.isEmpty()) list.add(-1);
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }


        return answer;
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int food = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (!visited[nx][ny] && map[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }

            }
            food += map[cur[0]][cur[1]] - '0';
        }
        list.add(food);
    }
}
}
