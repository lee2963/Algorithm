import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2623 {
    static int[] isDegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        isDegree = new int[n + 1];
        List<Integer>[] list = new List[n + 1];
        int[] seq = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int pre = -1;
            for (int j = 0; j < num; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (j != 0) {
                    list[pre].add(now);
                    isDegree[now]++;
                }

                pre = now;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            if(isDegree[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int now = q.poll();

            for (Integer next : list[now]) {
                isDegree[next]--;

                if(isDegree[next] == 0){
                    q.add(next);
                }
            }
            sb.append(now).append("\n");
            idx++;
        }


        if (idx != n) {
            System.out.println(0);
            return;
        }
        System.out.println(sb);
    }
}
