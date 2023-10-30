import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16973 {
    static int n, m;
    static boolean[][] map;
    static boolean[][]visited;
    static int[] end;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if(Integer.parseInt(st.nextToken()) == 1)
                    map[i][j] = true;
                else map[i][j] = false;
            }
        }

        end = new int[2];
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;
        end[0] = Integer.parseInt(st.nextToken()) - 1;
        end[1] = Integer.parseInt(st.nextToken()) - 1;


        System.out.println(bfs(startX, startY, h, w));
    }

    static int bfs(int startX, int startY, int h, int w) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == end[0] && now[1] == end[1]){
                return now[2];
            }

            for(int i = 0; i < 4; i++){ //우 하 좌 상
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                boolean flag = false;
                if(i == 0){
                    if(ny  + w - 1 < m){

                        for(int j = nx; j < nx + h; j++){
                            if(map[j][ny + w - 1]){
                                flag = true;
                                break;
                            }
                        }
                        if(!flag && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            q.add(new int[] {nx, ny , now[2] + 1});
                        }
                    }
                } else if(i == 1){

                    if(nx  + h - 1 < n){

                        for(int j = ny; j < ny + w; j++){
                            if(map[nx + h - 1][j]){
                                flag = true;
                                break;
                            }
                        }
                        if(!flag && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            q.add(new int[] {nx, ny , now[2] + 1});
                        }
                    }

                } else if(i == 2){

                    if(ny >= 0){
                        for(int j = nx; j < nx + h; j++){
                            if(map[j][ny]){
                                flag = true;
                                break;
                            }
                        }
                        if(!flag && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            q.add(new int[] {nx, ny , now[2] + 1});
                        }
                    }

                } else {
                    if(nx >= 0){

                        for(int j = ny; j < ny + w; j++){
                            if(map[nx][j]){
                                flag = true;
                                break;
                            }
                        }
                        if(!flag && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            q.add(new int[] {nx, ny , now[2] + 1});
                        }
                    }

                }
            }
        }
        return -1;
    }
}
