import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            List<Integer>[] list = new List[n + 1];
            int[] isDegree = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            int[] times = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int time = Integer.parseInt(st.nextToken());

                times[i] = time;
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                list[from].add(to);
                isDegree[to]++;
            }

            int target = Integer.parseInt(br.readLine());

            int[] maxTime = new int[n + 1];
            Queue<Integer> q = new LinkedList<>();
            for(int i = 1; i <= n; i++){
                if(isDegree[i] == 0){
                    q.add(i);
                    maxTime[i] = times[i];
                }
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                for (Integer next : list[now]) {
                    isDegree[next]--;

                    maxTime[next] = Math.max(maxTime[next], maxTime[now]);

                    if(isDegree[next] == 0){
                        q.add(next);
                        maxTime[next] += times[next];

                        if(next == target) break;
                    }
                }
            }

            System.out.println(maxTime[target]);
        }
    }
}
