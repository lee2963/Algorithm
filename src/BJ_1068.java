import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1068 {
    static List<Integer>[] node;
    static int root;
    static int remove;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        node = new ArrayList[n];

        for(int i = 0; i < n; i++){
            node[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if(parent == -1) root = i;
            else node[parent].add(i);
        }

        remove = Integer.parseInt(br.readLine());

        if(remove != root) dfs(root);

        System.out.println(answer);
    }
    static void dfs(int parent){

        if (node[parent].size() == 0) {
            answer++;
        } else if (node[parent].size() == 1 && node[parent].get(0) == remove) {
            answer++;
        }

        for (Integer child : node[parent]) {
            if(child != remove){
                dfs(child);
            }
        }
    }
}
