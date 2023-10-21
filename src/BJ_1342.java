import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1342 {
    static int[] arr;
    static int len;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        len = str.length();
        arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            arr[idx]++;
        }
        dfs(0, -1);

        System.out.println(answer);
    }

    static void dfs(int cnt, int pre){
        if(cnt == len){
            answer++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if(i != pre && arr[i] > 0){
                arr[i]--;
                dfs(cnt + 1, i);
                arr[i]++;
            }
        }

    }
}
