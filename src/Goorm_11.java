import java.io.*;
import java.util.*;

class Goorm_11 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(n % b == 0){
            System.out.println(n / b);
            return;
        }

        int answer = n / b;
        while(answer > 0){
            int num = n - (answer * b);

            if(num % a == 0){
                System.out.println(answer + (num / a));
                return;
            }
            answer--;
        }

        if(n % a == 0){
            System.out.println(n / a);
            return;
        }
        System.out.println(-1);
    }
}
