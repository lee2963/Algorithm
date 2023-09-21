import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_10423 {
    static int[] parent;
    static List<Node>graph;
    static class Node{
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int idx = Integer.parseInt(st.nextToken());
            parent[idx] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.add(new Node(from, to, cost));
        }


        int answer = 0;
        Collections.sort(graph, ((o1, o2) -> o1.cost - o2.cost));

        for (Node node : graph) {
            if (find(node.from) != find(node.to)) {
                union(node.from, node.to);
                answer += node.cost;
            }
        }

        System.out.println(answer);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x < y){
            parent[y] = x;
        } else{
            parent[x] = y;
        }
    }

    static int find(int x){
        if(parent[x] == x) return x;

        return find(parent[x]);
    }
}
