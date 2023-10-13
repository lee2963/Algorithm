import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CodeTree_MazeRunner {
    static int n, m, k;
    static int[][] personMap;
    static List<Person> persons;
    static int[][] map;
    static int exitX, exitY;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int move = 0;
    static class Person{
        int x;
        int y;
        int cnt;

        public Person(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        personMap = new int[n][n];
        persons = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            persons.add(new Person(x, y, 0));
        }

        st = new StringTokenizer(br.readLine());
        exitX = Integer.parseInt(st.nextToken()) - 1;
        exitY = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < k; i++) {
            personMove();

            if(persons.size() == 0){
                break;
            }
            setPersonMap();
            findSquare();
            reset();
        }

        System.out.println(move);
        System.out.println((exitX + 1) + " " + (exitY + 1));
    }

    static void personMove() {
        List<Integer> exit = new ArrayList<>();

        for (int j = 0; j < persons.size(); j++) {
            Person person = persons.get(j);
            int idx = -1;
            int curDist = Math.abs(person.x - exitX) + Math.abs(person.y - exitY);
            for (int i = 0; i < 4; i++) {
                int nx = person.x + dx[i];
                int ny = person.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    int dist = Math.abs(nx - exitX) + Math.abs(ny - exitY);
                    if (map[nx][ny] == 0 && curDist > dist) {
                        idx = i;
                        break;
                    }
                }
            }


            if (idx != -1) {
                person.x = person.x + dx[idx];
                person.y = person.y + dy[idx];
                person.cnt = person.cnt + 1;
                move++;
                if(person.x == exitX && person.y == exitY){
                    exit.add(j);
                }

            }
        }

        for (int i = exit.size() - 1; i >= 0; i--) {
            int idx = exit.get(i);
            persons.remove(idx);
        }
    }
    static void setPersonMap(){
        personMap = new int[n][n];

        for (Person person : persons) {
            personMap[person.x][person.y]++;
        }
    }

    static void findSquare(){

        int x = exitX;
        int y = exitY;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j + i < n && k + i < n) {
                        if(checkSquare(i, j, k)){
                            turnMaze(j, k, j + i, k + i, i);
                            return;
                        }
                    }

                }
            }
        }

    }

    static boolean checkSquare(int len, int x, int y) {

        if(exitX >= x && exitX <= x + len && exitY >= y && exitY <= y + len){
            for (int i = x; i <= x + len; i++) {
                for (int j = y; j <= y + len; j++) {
                    if(personMap[i][j] > 0) return  true;
                }
            }
        }
        return false;
    }

    static void turnMaze(int x1, int y1, int x2, int y2, int len){
        map[exitX][exitY] = -1;
        int[][] temp = new int[len + 1][len + 1];
        int[][] turn = new int[len + 1][len + 1];
        int[][] personTemp= new int[len + 1][len + 1];
        int[][] personTurn= new int[len + 1][len + 1];

        for(int i = x1; i <= x2; i++){
            for (int j = y1; j <= y2; j++) {
                temp[i - x1][j - y1] = map[i][j];
                personTemp[i - x1][j - y1] = personMap[i][j];
            }
        }

        for(int i = 0; i <= len; i++){
            for(int j = 0; j <= len; j++){
                turn[i][j] = temp[len - j][i];
                personTurn[i][j] = personTemp[len - j][i];
            }
        }

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                map[i][j] = turn[i - x1][j - y1];
                personMap[i][j] = personTurn[i - x1][j - y1];
                if(map[i][j] > 0 ) map[i][j]--;

                if(map[i][j] == -1){
                    exitX = i;
                    exitY = j;
                    map[i][j] = 0;
                }
            }
        }
    }

    static void reset() {
        persons.clear();

        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < personMap[i][j]; k++) {
                    persons.add(new Person(i, j, k));
                }
            }
        }
    }
}
