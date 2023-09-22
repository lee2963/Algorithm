class Pg_49994 {
    public int solution(String dirs) {

        return func(dirs);
    }
    static int func(String dirs){

        boolean[][][] visited = new boolean[11][11][4];
        int x = 5;
        int y = 5;
        int cnt = 0;


        for(int i = 0; i < dirs.length(); i++){
            char now = dirs.charAt(i);

            if(now == 'U'){
                if(x + 1 < 11) {
                    x += 1;
                    if(!visited[x][y][0]){
                        cnt++;
                        visited[x][y][0] = true;
                        visited[x - 1][y][1] = true;
                    }
                }
            } else if(now == 'D'){
                if(x - 1 >= 0) {
                    x -= 1;
                    if(!visited[x][y][1]){
                        cnt++;
                        visited[x][y][1] = true;
                        visited[x + 1][y][0] = true;
                    }
                }
            } else if(now == 'L'){
                if(y - 1 >= 0) {
                    y -= 1;
                    if(!visited[x][y][2]){
                        cnt++;
                        visited[x][y][2] = true;
                        visited[x][y + 1][3] = true;
                    }
                }
            } else if(now == 'R'){
                if(y + 1 < 11) {
                    y += 1;
                    if(!visited[x][y][3]){
                        cnt++;
                        visited[x][y][3] = true;
                        visited[x][y - 1][2] = true;
                    }
                }
            }
        }
        return cnt;
    }
}