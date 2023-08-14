class Pg_43162 {
    static boolean[] visited;
    static int N;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                visited[i] = true;
                dfs(i, computers);
            }
        }
        return answer;
    }

    void dfs(int next, int[][] computers){

        for(int i = 0; i < N; i++){
            if(computers[next][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i, computers);
            }
        }
    }
}
