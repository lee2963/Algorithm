import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1766 {
    static List<Integer>[] map;
    static int[] inDegree;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        inDegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int easy = Integer.parseInt(st.nextToken());
            int hard = Integer.parseInt(st.nextToken());

            map[easy].add(hard);
            inDegree[hard]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if(inDegree[i] == 0){
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll();

            sb.append(cur).append(" ");
            for (Integer next : map[cur]) {
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    pq.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
