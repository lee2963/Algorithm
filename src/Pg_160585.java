class Pg_160585 {
    static int[] dx ={0, 1, 1, 1};
    static int[] dy ={1, 0, 1, -1};
    static int O = 0;
    static int X = 0;
    static int o = 0;
    static int x = 0;
    public int solution(String[] board) {
        int answer = 0;

        if(!count(board)) return 0;

        checkBingo(board);

        if(O > 0 && X > 0) return 0;

        if(O > 0 && o == x) return 0;

        if(X > 0 && o > x) return 0;


        return 1;
    }

    static boolean count(String[] board){

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                char ch = board[i].charAt(j);
                if(ch == 'O') o++;
                else if(ch == 'X') x++;
            }
        }

        int result = o - x;

        if(result == 0 || result == 1){
            return true;
        }
        return false;
    }

    static void checkBingo(String[] board){

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j) != '.'){
                    for(int k = 0; k < 4; k++){
                        dfs(i, j, board, k, 1);
                    }
                }
            }
        }
    }

    static void dfs(int x, int y, String[] board, int dir, int cnt){

        if(cnt == 3){
            if(board[x].charAt(y) == 'O')
                O++;
            else X++;
            return;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(ny >= 0 && nx < 3 && ny < 3){
            if(board[x].charAt(y) == board[nx].charAt(ny))
                dfs(nx, ny, board, dir, cnt + 1);
        }

    }
}