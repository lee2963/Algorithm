import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2252 {
    static List<Integer>[] node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        node = new ArrayList[n + 1];
        int[] isDegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            node[a].add(b);
            isDegree[b]++;
        }


        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (isDegree[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int cur = q.poll();

            sb.append(cur).append(" ");
            for (Integer next : node[cur]) {
                isDegree[next]--;

                if(isDegree[next] == 0){
                    q.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
