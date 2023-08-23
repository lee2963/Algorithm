import java.util.*;

class Pg_42861 {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        for(int i = 0; i < costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                answer += costs[i][2];
                union(costs[i][0], costs[i][1]);
            }
        }

        return answer;
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x > y) parent[x] = y;
        else parent[y] = x;
    }

    static int find(int x){
        if(x == parent[x]) return x;

        return find(parent[x]);
    }
}