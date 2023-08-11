import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();
            if(s == null) {
                break;
            }
            int N = Integer.parseInt(s);
            int num = 0;
            for(int i=1; i<=N; i++) {
                num = num*10 + 1;
                num %= N;

                if(num == 0) {
                    System.out.println(i);
                    break;
                }
            }

        }
    }
}
