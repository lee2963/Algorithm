import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[n + 1];
        int[] isDegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            isDegree[y]++;
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(isDegree[i] == 0) q.add(new int[]{i, 1});
        }

        int[] seq = new int[n + 1];
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (Integer next : list[now[0]]) {
                isDegree[next]--;

                if(isDegree[next] == 0) q.add(new int[] {next, now[1] + 1});
            }
            seq[now[0]] = now[1];

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(seq[i]).append(" ");
        }
        System.out.println(sb);
    }
}
