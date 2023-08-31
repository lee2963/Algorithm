import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2023 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dfs(0, n);

        System.out.println(sb);
    }

    static void dfs(int num, int n) {
        if(n==0) {
            sb.append(num).append("\n");
        }

        for(int i=1; i<10; i++) {
            int tmp = 10*num +i;

            if(n>0 && isPrime(tmp)) {
                dfs(tmp, n-1);
            }
        }
    }

    static boolean isPrime(int num) {
        if(num <2) return false;

        for(int i=2 ; i*i<=num; i++) {
            if(num%i ==0) {
                return false;
            }
        }
        return true;
    }
}
