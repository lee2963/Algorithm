import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.DoubleStream;

public class BJ_1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] map = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        int[] degree = new int[n + 1];
        int[] time = new int[n + 1];
        int[] calTime = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true){
                int from = Integer.parseInt(st.nextToken());

                if(from == -1) break;

                map[from].add(i);
                degree[i]++;
            }
        }



        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(degree[i] == 0){
                q.add(i);
                calTime[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (Integer next : map[now]) {
                degree[next]--;
                calTime[next] = Math.max(calTime[next], calTime[now]);

                if(degree[next] == 0){
                    q.add(next);
                    calTime[next] += time[next];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(calTime[i]).append("\n");
        }
        System.out.println(sb);
    }
}
