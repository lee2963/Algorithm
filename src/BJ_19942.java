import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_19942 {
    static int n;
    static int[][] arr;
    static int[] line;
    static int[] cost;
    static int min = Integer.MAX_VALUE;
    static List<Integer> seq;
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][4];
        line = new int[4];
        cost = new int[n];
        answer = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            seq = new ArrayList<>();
            seq.add(i);
            dfs(i, arr[i][0], arr[i][1], arr[i][2], arr[i][3], cost[i]);
        }


        if(min != Integer.MAX_VALUE){
            StringBuilder sb = new StringBuilder();
            sb.append(min).append("\n");

            for (Integer integer : answer) {
                sb.append(integer).append(" ");
            }
            System.out.println(sb);
            return;
        }
        System.out.println(-1);
    }

    static void dfs(int idx, int mp, int mf, int ms, int mv, int sum) {
        if(mp >= line[0] && mf >= line[1] && ms >= line[2] && mv >= line[3]){
            if(min > sum) {
                min = sum;
                answer.clear();

                for (Integer integer : seq) {
                    answer.add(integer + 1);
                }
            }

            return;
        }

        for (int i = idx + 1; i < n; i++) {
            seq.add(i);
            dfs(i, mp + arr[i][0], mf + arr[i][1], ms + arr[i][2], mv + arr[i][3], sum + cost[i]);
            seq.remove(seq.size() - 1);
        }

    }
}
