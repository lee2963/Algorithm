import java.util.*;

class Pg_49189 {
    static List<Integer>[] list;
    static int[] visited;
    static int answer = 0;
    public int solution(int n, int[][] edge) {
        list = new ArrayList[n + 1];
        visited = new int[n + 1];

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge.length; i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }

        bfs();

        return answer;
    }

    static void bfs(){

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;

        int max = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(Integer next : list[cur]){
                if(visited[next] == 0){
                    visited[next] = visited[cur] + 1;

                    if(max == visited[next]){
                        answer++;
                    } else if(max < visited[next]){
                        answer = 1;
                        max = visited[next];
                    }
                    q.add(next);
                }
            }
        }
    }
}
