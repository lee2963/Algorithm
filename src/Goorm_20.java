import java.io.*;
        import java.util.*;

class Goorm_20 {
    static int n, k;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0 , -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        map = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = st.nextToken().charAt(0);

            visited = new boolean[n][n];
            bfs(x, y);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> move = new LinkedList<>();

        q.add(new int[]{x, y});
        visited[x][y] = true;
        char target = map[x][y];

        while(!q.isEmpty()){
            int[] now = q.poll();
            move.add(now);

            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if(!visited[nx][ny] && map[nx][ny] == target){
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        if(move.size() >= k){
            while(!move.isEmpty()){
                int[] now = move.poll();

                map[now[0]][now[1]] = '.';
            }
        }
    }
}
