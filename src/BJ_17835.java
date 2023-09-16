import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_17835 {
    static long[] dist;
    static List<Node>[] graph;
    static PriorityQueue<Node> pq;
    static class Node implements Comparable<Node>{
        int e;
        long w;

        public Node(int e, long w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.w, o.w);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dist = new long[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[end].add(new Node(start, cost));
        }

        int answer[] = new int[n + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        pq = new PriorityQueue<>();
        Arrays.fill(dist, Long.MAX_VALUE);
        for (int i = 0; i < k; i++) {
            int place = Integer.parseInt(st.nextToken());

            pq.add(new Node(place, 0));
            dist[place] = 0;
        }

        func();

        long res = 0;
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (res < dist[i]) {
                idx = i;
                res = dist[i];
            }

        }

        System.out.println(idx);
        System.out.println(res);

    }

    static void func() {

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dist[cur.e] < cur.w) continue;
            for (Node next : graph[cur.e]) {
                if (dist[next.e] > dist[cur.e] + next.w) {
                    dist[next.e] = dist[cur.e] + next.w;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }

    }
}
