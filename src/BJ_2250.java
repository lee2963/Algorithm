import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2250 {
    static int n;
    static int[] min, max;
    static Node[] node;
    static int idx = 1;
    static class Node{
        int parent;
        int num;
        int left;
        int right;

        public Node(int num, int left, int right) {
            this.parent = -1;
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        node = new Node[n + 1];
        min = new int[n + 1];
        max = new int[n + 1];

        Arrays.fill(min, n);
        Arrays.fill(max, 0);

        for(int i = 1; i <= n; i++){
            node[i] = new Node(i, -1, -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            node[v].left = left;
            node[v].right = right;

            if(left != -1) node[left].parent = v;
            if(right != -1) node[right].parent = v;
        }

        int root = 1;
        for (int i = 1; i <= n; i++) {
            if(node[i].parent == -1){
                root = i;
                break;
            }
        }

        nodeSearch(root, 1);

        int level = 1;
        int val = 1;
        for(int i = 2; i <= n; i++){
            if(max[i] - min[i] + 1 > val){
                val = max[i] - min[i] + 1;
                level = i;
            }
        }

        System.out.println(level + " " + val);
    }

    static void nodeSearch(int parent, int level){
        Node now = node[parent];

        if(now.left != -1){
            nodeSearch(now.left, level + 1);
        }

        min[level] = Math.min(idx, min[level]);
        max[level] = Math.max(idx, max[level]);
        idx++;

        if(now.right != - 1){
            nodeSearch(now.right, level + 1);
        }

    }
}
