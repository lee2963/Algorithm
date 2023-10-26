import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_13905 {
    static int n, m;
    static int start, end;
    static int[] parent;
    static class Node {
        int from;
        int to;
        int w;

        public Node(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        Node[] nodes = new Node[m];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(from, to, w);
        }

        Arrays.sort(nodes, ((o1, o2) -> o2.w - o1.w));
        int val = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            if (find(nodes[i].from) != find(nodes[i].to)) {
                union(nodes[i].from, nodes[i].to);
                val = Math.min(nodes[i].w, val);
            }

            if(find(start) == find(end)){
                break;
            }
        }

        if(find(start) != find(end)) val = 0;

        System.out.println(val);

    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x > y) parent[x] = y;
        else parent[y] = x;
    }
}
