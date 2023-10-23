import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String target = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            int now = target.charAt(i) - '0';

            while (!stack.isEmpty() && stack.peek() < now && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(now);
        }

        StringBuffer answer = new StringBuffer();

        if(k > 0){
            for(int i = 0; i < k; i++){
                stack.pop();
            }
        }

        while(!stack.isEmpty()){
            answer.insert(0, stack.pop());
        }

        System.out.println(answer);
    }
}
