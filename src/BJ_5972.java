import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_5972 {
    static List<Node>[] graph;
    static int[] dist;
    static class Node{
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        dist = new int[n + 1];

        Arrays.fill(dist, 1000000000);

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, c));
            graph[e].add(new Node(s, c));
        }

        dijkstra();

        System.out.println(dist[n]);

    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next : graph[cur.e]) {
                if (dist[next.e] > dist[cur.e] + next.cost) {
                    dist[next.e] = dist[cur.e] + next.cost;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }
    }
}
