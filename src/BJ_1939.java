import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1939 {
    static int n;
    static List<Bridge>[] bridge;
    static boolean[] visited;
    static class Bridge{
        int arrive;
        int w;

        public Bridge(int arrive, int w) {
            this.arrive = arrive;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bridge = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            bridge[i] = new ArrayList<>();
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int island1 = Integer.parseInt(st.nextToken());
            int island2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            min = Math.min(min, w);
            max = Math.max(max, w);

            bridge[island1].add(new Bridge(island2, w));
            bridge[island2].add(new Bridge(island1, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int answer = 0;
        while(min <= max ){
            int mid = (min + max) / 2;
            visited = new boolean[n + 1];

            if (bfs(start, end, mid)) {
                min = mid + 1;
                answer = mid;
            } else{
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static boolean bfs(int start, int end, int w) {

        Queue<Integer> q = new LinkedList<>();
        visited[start]  = true;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if(cur == end){
                return true;
            }

            for (Bridge next : bridge[cur]) {
                if(!visited[next.arrive] && next.w >= w){
                    visited[next.arrive] = true;
                    q.add(next.arrive);
                }
            }
        }
        return false;
    }
}
