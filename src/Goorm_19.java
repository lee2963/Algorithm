import java.io.*;
import java.util.*;

class Goorm_19 {
    static int n;
    static List<Integer>[] road;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        road = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            road[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());

            road[city1].add(city2);
            road[city2].add(city1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            if(i == s || i == e){
                sb.append(-1).append("\n");
                continue;
            }

            sb.append(bfs(s, e, i)).append("\n");
        }
        System.out.println(sb);
    }
    static int bfs(int s, int e, int work){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[n + 1];
        pq.add(new int[]{s, 1});
        visited[s] = true;
        visited[work] = true;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(cur[0] == e){
                return cur[1];
            }
            for(Integer next : road[cur[0]]){
                if(!visited[next]){
                    visited[next] = true;
                    pq.add(new int[]{next, cur[1] + 1});
                }
            }
        }
        return -1;
    }
}
