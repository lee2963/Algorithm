import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2529 {
    static boolean[] visited;
    static int n;
    static char[] input;
    static boolean chk = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        input = new char[n];

        for (int i = 0; i < n; i++) {
            input[i] = str[i].charAt(0);
        }
        visited = new boolean[10];

        for (int i = 9; i >= 0; i--) {
            List<Integer> list = new ArrayList<>();
            visited[i] = true;
            list.add(i);
            downDfs(i, 0, list);
            visited[i] = false;
        }
        System.out.println();

        visited = new boolean[10];
        chk = false;
        for (int i = 0; i <= 9; i++) {
            List<Integer> list = new ArrayList<>();
            visited[i] = true;
            list.add(i);
            upDfs(i, 0, list);
            visited[i] = false;
        }

    }

    static void downDfs(int pre, int cnt, List<Integer> list){
        if (cnt == n) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            chk = true;
        }

        for (int i = 9; i >=0 ; i--) {
            if (!visited[i] && !chk) {
                if (input[cnt] == '<') {
                    if (pre < i) {
                        list.add(i);
                        visited[i] = true;
                        downDfs(i , cnt + 1, list);
                        visited[i] = false;
                        list.remove(list.size() - 1);
                    }
                } else if(input[cnt] == '>'){
                    if (pre > i) {
                        list.add(i);
                        visited[i] = true;
                        downDfs(i , cnt + 1, list);
                        visited[i] = false;
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
    }

    static void upDfs(int pre ,int cnt, List<Integer> list) {

        if (cnt == n) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            chk = true;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i] && !chk) {
                if (input[cnt] == '<') {
                    if (pre < i) {
                        list.add(i);
                        visited[i] = true;
                        upDfs(i , cnt + 1, list);
                        visited[i] = false;
                        list.remove(list.size() - 1);
                    }
                } else if (input[cnt] == '>'){
                    if (pre > i) {
                        list.add(i);
                        visited[i] = true;
                        upDfs(i , cnt + 1, list);
                        visited[i] = false;
                        list.remove(list.size() - 1);
                    }
                }
            }
        }

    }
}
