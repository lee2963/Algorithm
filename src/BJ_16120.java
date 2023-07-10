import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_16120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'P') {
                s.add('P');
            } else{
                if (s.size() >= 2 && i < input.length - 1 && input[i + 1] == 'P') {
                    s.pop();
                    s.pop();
                } else{
                    System.out.println("NP");
                    return;
                }
            }
        }

        if (s.size() == 1) {
            System.out.println("PPAP");
        } else{
            System.out.println("NP");
        }

    }
}
