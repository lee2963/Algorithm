import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14938 {
    static List<Node>[] list;
    static int[] item;
    static int n, m;
    static class Node implements Comparable<Node>{
        int to;
        int d;

        public Node(int to, int d) {
            this.to = to;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        list = new List[n + 1];
        item = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, w));
            list[to].add(new Node(from, w));
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dijkstra(i));
        }


        System.out.println(max);
    }

    static int dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : list[now.to]) {
                if(dist[next.to] > dist[now.to] + next.d){
                    dist[next.to] = dist[now.to] + next.d;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] <= m) sum += item[i];
        }

        return sum;
    }

}
