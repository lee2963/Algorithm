import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_25663 {
    static int[] num;
    static boolean[] visited;
    static int n, m;
    static Set<String> set = new HashSet<>();
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        dfs(0, "");

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int cnt, String str) {

        if (cnt == m) {
            if (!set.contains(str)) {
                list.add(str);
                set.add(str);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cnt + 1, str + num[i] + " ");
                visited[i] = false;
            }
        }
    }
}
