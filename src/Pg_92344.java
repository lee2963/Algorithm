class Pg_92344 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int[][] preSum = new int[board.length + 1][board[0].length + 1];

        for(int i = 0; i < skill.length; i++){
            int degree = skill[i][5];
            if(skill[i][0] == 1) degree = -degree;

            int r1 = skill[i][1], c1 = skill[i][2];
            int r2 = skill[i][3], c2 = skill[i][4];

            preSum[r1][c1] += degree;
            preSum[r1][c2 + 1] -= degree;
            preSum[r2 + 1][c1] -= degree;
            preSum[r2 + 1][c2 + 1] += degree;
        }

        for(int i = 0; i < preSum.length; i++){
            int sum = 0;
            for(int j = 0; j < preSum[0].length; j++){
                sum += preSum[i][j];
                preSum[i][j] = sum;
            }
        }

        for(int i = 0; i < preSum[0].length; i++){
            int sum = 0;
            for(int j = 0; j < preSum.length; j++){
                sum += preSum[j][i];
                preSum[j][i] = sum;
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(preSum[i][j] + board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}