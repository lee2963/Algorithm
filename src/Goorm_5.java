import java.io.*;
import java.util.*;

class Goorm_5 {
    static class Num{
        int num;
        int cnt;

        public Num(int num){
            this.num = num;
            int cnt = 0;

            String binary = Integer.toBinaryString(num);
            for(int i = 0; i < binary.length(); i++){
                if(binary.charAt(i) == '1'){
                    cnt++;
                }
            }
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Num[] arr = new Num[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            arr[i] = new Num(num);
        }

        Arrays.sort(arr, new Comparator<Num>(){

            public int compare(Num n1, Num n2){
                if(n1.cnt == n2.cnt){
                    return n2.num - n1.num;
                }

                return n2.cnt - n1.cnt;
            }
        });

        System.out.print(arr[k - 1].num);
    }
}