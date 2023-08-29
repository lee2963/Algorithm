import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_3584 {
    static List<Integer>[] parent;
    static Set<Integer> set;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            answer = 0;

            parent = new ArrayList[n + 1];
            set = new HashSet<>();

            for (int i = 1; i <= n; i++) {
                parent[i] = new ArrayList<>();
            }

            for (int i = 1; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int parentNode = Integer.parseInt(st.nextToken());
                int childNode = Integer.parseInt(st.nextToken());
                parent[childNode].add(parentNode);
            }

            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            dfs(node1);
            if(set.contains(node2)){
                System.out.println(node2);
            } else{
                chkParent(node2);
                System.out.println(answer);
            }

        }
    }

    static void dfs(int child) {
        set.add(child);
        for (Integer next : parent[child]) {
            dfs(next);
        }
    }

    static void chkParent(int child) {

        for (Integer next : parent[child]) {
            if (set.contains(next)) {
                answer = next;
                return;
            }
        }

        for (Integer next : parent[child]) {
            chkParent(next);
        }
    }
}
