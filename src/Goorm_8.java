import java.io.*;

class Goorm_8 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] arr = {14, 7 , 1};

        for(int i = 0; i < 3; i++){
            answer += n / arr[i];
            n %= arr[i];
        }

        System.out.print(answer);
    }
}