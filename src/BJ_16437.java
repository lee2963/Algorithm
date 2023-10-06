import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_16437 {
    static List<Integer>[] list;
    static Kind[] info;
    static int n;
    static int answer = 0;
    static class Kind{
        long v;
        boolean animal;

        public Kind(int v, boolean animal) {
            this.v = v;
            this.animal = animal;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        info = new Kind[n + 1];
        info[1] = new Kind(0, true);

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 2; i <= n; i++){
            st = new StringTokenizer(br.readLine());

            char animal = st.nextToken().charAt(0);
            int v = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());

            list[parent].add(i);
            if(animal == 'S'){
                info[i] = new Kind(v, true);
            } else{
                info[i] = new Kind(v, false);
            }
        }


        System.out.println(dfs(1));
    }

    static long dfs(int parent){
        long sum = 0;

        for (Integer child : list[parent]) {
            sum += dfs(child);
        }

        if (info[parent].animal) {
            return sum + info[parent].v;
        } else {
            if(sum - info[parent].v > 0){
                return sum - info[parent].v;
            } else{
                return 0;
            }
        }
    }
}
