import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_9328 {
    static char[][] map;
    static int r, c;
    static boolean[][] visited;
    static boolean[] key;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map = new char[r + 2][c + 2];
            visited = new boolean[r + 2][c + 2];
            key = new boolean[26];

            for(int i = 0; i < r + 2; i++) Arrays.fill(map[i], '.');

            for (int i = 1; i <= r; i++) {
                String str = br.readLine();
                for (int j = 1; j <= c; j++) {
                    map[i][j] = str.charAt(j - 1);
                }
            }

            String keyList = br.readLine();

            for (int i = 0; i < keyList.length(); i++) {
                char ch = keyList.charAt(i);

                if(ch != '0') key[ch - 'a'] = true;
            }

            sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new int[]{0, 0});
        int cnt = 0;
        List<int[]>[] door = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            door[i] = new ArrayList<>();
        }
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r + 2 && ny < c + 2) {
                    if(!visited[nx][ny]){
                        if (map[nx][ny] != '*') {
                            if(map[nx][ny] >= 'a' && map[nx][ny] <= 'z'){
                                visited[nx][ny] = true;
                                key[map[nx][ny] - 'a'] = true;
                                q.add(new int[]{nx, ny});

                                for (int[] point : door[map[nx][ny] - 'a']) {
                                    if (!visited[point[0]][point[1]]) {
                                        q.add(point);
                                        visited[point[0]][point[1]] = true;
                                    }
                                }
                                map[nx][ny] = '.';

                            } else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'Z'){
                                if(key[map[nx][ny] - 'A']){
                                    map[nx][ny] = '.';
                                    q.add(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                } else{
                                    door[map[nx][ny] - 'A'].add(new int[]{nx, ny});
                                }
                            } else if(map[nx][ny] == '$'){
                                visited[nx][ny] = true;
                                map[nx][ny] = '.';
                                cnt++;
                                q.add(new int[]{nx, ny});
                            } else{
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }
}
