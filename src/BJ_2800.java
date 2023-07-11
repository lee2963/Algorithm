import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2800 {
    static List<Pair> index = new ArrayList<>();
    static TreeSet<String> answer = new TreeSet<>();
    static class Pair{
        int open;
        int close;

        public Pair(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            }

            if (str.charAt(i) == ')') {
                index.add(new Pair(stack.pop(), i));
            }
        }

        dfs(0, str);

        answer.remove(str);

        for (String s : answer) {
            System.out.println(s);
        }

    }

    static void dfs(int cur, String str) {

        answer.add(str.replaceAll(" ", ""));

        if (cur == index.size()) {
            return;
        }

        Pair pair = index.get(cur);
        StringBuilder remove = new StringBuilder(str);
        remove.setCharAt(pair.open, ' ');
        remove.setCharAt(pair.close, ' ');

        dfs(cur + 1, remove.toString());


        dfs(cur + 1, str);
    }
}
