import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_23290 {
    static List<Fish> fishes = new ArrayList<>();
    static int[] shark;
    static int[][] dead;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] sx = {-1, 0, 1, 0};
    static int[] sy = {0, -1, 0, 1};
    static int max = 0;
    static int[][] sharkRoad;
    static int[][] road;
    static List<Fish>[][] map;
    static int[][] graph;

    static class Fish{
        int x;
        int y;
        int dir;

        public Fish(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        fishes = new ArrayList<>();
        shark = new int[2];
        dead = new int[4][4];
        sharkRoad = new int[3][2];
        road = new int[3][2];
        map = new List[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            fishes.add(new Fish(x, y, d));
        }

        st = new StringTokenizer(br.readLine());
        shark[0] = Integer.parseInt(st.nextToken()) - 1;
        shark[1] = Integer.parseInt(st.nextToken()) - 1;

        for (int t = 0; t < s; t++) {

            List<Fish> copy = new ArrayList<>();

            for (Fish fish : fishes) {
                int x = fish.x;
                int y = fish.y;
                int d = fish.dir;

                copy.add(new Fish(x, y, d));
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if(dead[i][j] > 0) dead[i][j]--;
                }
            }

            for (Fish fish : fishes) {
                fish = moveFish(fish);
            }

            for (Fish fish : fishes) {
                map[fish.x][fish.y].add(fish);
            }

            graph = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    graph[i][j] = map[i][j].size();
                }
            }

            max = -1;
            moveShark(0, shark[0], shark[1], 0);
            killFish();

            shark[0] = sharkRoad[2][0];
            shark[1] = sharkRoad[2][1];

            fishes = new ArrayList<>();
            for (Fish fish : copy) {
                fishes.add(fish);
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {

                    for (Fish fish : map[i][j]) {
                        fishes.add(fish);
                    }

                    map[i][j].clear();
                }
            }

        }
        System.out.println(fishes.size());

    }

    static Fish moveFish(Fish fish){

        int x = fish.x;
        int y = fish.y;
        int d = fish.dir;
        int cnt = 0;
        while(true){
            cnt++;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4){
                if(dead[nx][ny] == 0 && !(shark[0] == nx && shark[1] == ny)){
                    fish.x = nx;
                    fish.y = ny;
                    fish.dir = d;
                    break;
                }
            }
            d--;
            if (d < 0) d = 7;

            if(cnt == 8){
                break;
            }
        }
        return fish;

    }

    static void moveShark(int cnt, int x, int y, int sum){

        if(cnt == 3){
            if(sum > max){
                for (int i = 0; i < 3; i++) {
                    sharkRoad[i][0] = road[i][0];
                    sharkRoad[i][1] = road[i][1];
                }
                max = sum;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + sx[i];
            int ny = y + sy[i];

            if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4){
                int size = graph[nx][ny];
                graph[nx][ny] = 0;
                road[cnt][0] = nx;
                road[cnt][1] = ny;
                moveShark(cnt + 1, nx, ny, sum + size);
                graph[nx][ny] = size;
            }

        }
    }

    static void killFish(){

        for (int i = 0; i < 3; i++) {
            if(!map[sharkRoad[i][0]][sharkRoad[i][1]].isEmpty()){
                map[sharkRoad[i][0]][sharkRoad[i][1]].clear();
                dead[sharkRoad[i][0]][sharkRoad[i][1]] = 3;
            }

        }
    }

}
