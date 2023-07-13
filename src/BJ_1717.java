import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1717 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int operand = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (operand == 0) {
                union(x, y);
            } else if (operand == 1) {
                System.out.println(parent[x] + " " + find(x));
                System.out.println(parent[y] + " " + find(y));
                if (find(x) == find(y)) {
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            }
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else{
                parent[x] = y;
            }
        }
    }

    static int find(int x) {

        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
