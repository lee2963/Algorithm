import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1941 {
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];

        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }


        dfs(new int[7], 0, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int[] comb, int cnt, int idx, int depth) {

        if (cnt == 7) {
            bfs(comb);
            return;
        }

        if (depth >= 25)  return;

        comb[idx] = depth;
        dfs(comb, cnt + 1, idx + 1, depth + 1);
        dfs(comb, cnt, idx, depth + 1);
    }

    static void bfs(int[] comb) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[7];
        q.add(comb[0]);
        int sCnt = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            int nowX = now % 5;
            int nowY = now / 5;

            if(map[nowX][nowY] == 'S') sCnt++;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                for (int j = 1; j < 7; j++) {
                    if (!visited[j] && comb[j] % 5 == nx && comb[j] / 5 == ny) {
                        visited[j] = true;
                        q.add(comb[j]);
                    }
                }
            }
            cnt++;
        }

        if (cnt == 7) {
            if(sCnt >= 4) answer++;
        }
    }
}
