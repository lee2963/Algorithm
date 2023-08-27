import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14267 {
    static List<Integer>[] child;
    static int[] point;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        point = new int[n + 1];
        child = new List[n + 1];
        int root = -1;
        for (int i = 1; i <= n; i++) {
            child[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) child[parent].add(i);
            else if (parent == -1) root = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            point[start] += score;
        }

        dfs(root);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(point[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void dfs(int parent) {

        for (Integer child : child[parent]) {
            point[child] += point[parent];
            dfs(child);
        }
    }
}
