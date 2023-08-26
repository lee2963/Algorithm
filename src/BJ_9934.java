import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_9934 {
    static int k;
    static int[] arr;
    static List<Integer>[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        arr = new int[(int) Math.pow(2, k) - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = new ArrayList[k];

        for(int i = 0; i < k; i++){
            answer[i] = new ArrayList<>();
        }

        func(0, arr.length, 0);

        for (int i = 0; i < k; i++) {
            for (Integer node : answer[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    static void func(int start, int end, int depth) {

        if(depth == k) return;

        int mid = (start + end) / 2;

        answer[depth].add(arr[mid]);

        func(start, mid - 1, depth + 1);
        func(mid + 1, end, depth + 1);

    }
}
