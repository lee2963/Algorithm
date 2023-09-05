import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] isDegree = new int[n + 1];
        List<Integer>[] node = new List[n + 1];

        for(int i = 1; i <= n; i++){
            node[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());

            int len = Integer.parseInt(st.nextToken());
            isDegree[i] = len;
            for (int j = 0; j < len; j++) {
                node[Integer.parseInt(st.nextToken())].add(i);
            }
        }
        int[] result = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            result[i] = arr[i];
            if (isDegree[i] == 0) {
                q.add(i);
            }
        }


        while (!q.isEmpty()) {
            int cur = q.poll();

            for(Integer next : node[cur]){
                isDegree[next]--;

                result[next] = Math.max(result[next] , result[cur] + arr[next]);
                if(isDegree[next] == 0){
                    q.add(next);
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer = Math.max(result[i], answer);
        }

        System.out.println(answer);
    }
}
