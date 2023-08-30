import java.io.*;
import java.util.*;

class Goorm_13 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    int cnt = bfs(i, j);

                    if(cnt >= k){
                        m.put(map[i][j] , m.getOrDefault(map[i][j], 0) + 1);
                    }
                }
            }
        }

        int answer = 0;
        int max = 0;
        for(Integer val : m.keySet()){
            int num = m.get(val);
            if(max < num){
                answer = val;
                max = num;
            } else if(max == num && answer < val){
                answer = val;
                max = num;
            }
        }
        System.out.print(answer);
    }

    static int bfs(int x, int y){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if(!visited[nx][ny] && map[nx][ny] == map[x][y]){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}