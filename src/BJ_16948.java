import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }

        int[][] point = new int[2][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> q = new LinkedList<>();
        map[point[0][0]][point[0][1]] = 0;
        q.add(new int[]{point[0][0], point[0][1]});
        int[] dx = {-2, -2, 0, 0, 2, 2};
        int[] dy = {-1, 1, -2, 2, -1, 1};

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 6; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(map[nx][ny] > map[cur[0]][cur[1]] + 1){
                        map[nx][ny] = map[cur[0]][cur[1]] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        if (map[point[1][0]][point[1][1]] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(map[point[1][0]][point[1][1]]);
    }
}
