public class Pg_77485 {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        int num = 1;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                map[i][j] = num++;
            }
        }

        for(int i = 0; i < queries.length; i++){
            answer[i] = rotate(queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);

        }

        return answer;
    }

    static int rotate(int x1, int y1, int x2, int y2){
        int min = Integer.MAX_VALUE;

        int temp = map[x1][y2];
        min = Math.min(temp, min);
        for(int i = y2; i > y1; i--){
            map[x1][i] = map[x1][i - 1];
            min = Math.min(map[x1][i], min);
        }

        int temp1 = map[x2][y2];
        min = Math.min(temp1, min);
        for(int i = x2; i > x1 + 1; i--){
            map[i][y2] = map[i - 1][y2];
            min = Math.min(map[i][y2], min);
        }
        map[x1 + 1][y2] = temp;


        temp = map[x2][y1];
        min = Math.min(temp, min);
        for(int i = y1; i < y2 - 1; i++){
            map[x2][i] = map[x2][i + 1];
            min = Math.min(map[x2][i], min);
        }
        map[x2][y2 - 1] = temp1;


        for(int i = x1; i < x2 - 1; i++){
            map[i][y1] = map[i + 1][y1];
            min = Math.min(map[i][y1], min);
        }
        map[x2-1][y1] = temp;

        return min;
    }
}
