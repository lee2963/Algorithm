import java.io.*;
import java.util.*;

class Goorm_17 {
    static List<Integer>[] graph;
    static boolean[] nodeVisited;
    static double density = 0;
    static List<Integer> answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        nodeVisited = new boolean[n + 1];
        answer = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());

            graph[com1].add(com2);
            graph[com2].add(com1);
        }

        for(int i = 1; i <= n; i++){
            if(!nodeVisited[i]){
                bfs(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Integer node : answer){
            sb.append(node).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs(int idx){
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        nodeVisited[idx] = true;
        List<Integer> node = new ArrayList<>();
        node.add(idx);
        int cnt = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(Integer next : graph[cur]){
                cnt++;
                if(!nodeVisited[next]){
                    q.add(next);
                    nodeVisited[next] = true;
                    node.add(next);
                }
            }
        }
        Collections.sort(node);

        double newDensity = (double) cnt / (double) node.size();

        if(density < newDensity){
            density = newDensity;
            answer = new ArrayList<>(node);
        } else if(density == newDensity){
            if(answer.size() > node.size()){
                density = newDensity;
                answer = new ArrayList<>(node);
            } else if(answer.size() == node.size()){
                if(node.get(0) < answer.get(0)){
                    density = newDensity;
                    answer = new ArrayList<>(node);
                }
            }
        }
    }
}
