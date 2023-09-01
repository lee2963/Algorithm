import java.io.*;
import java.util.*;

class Goorm_15 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = arr[i][1] / arr[i][0];
        }

        Arrays.sort(arr, (o1, o2) -> o2[2] - o1[2]);

        long answer = 0;
        for(int i = 0; i < n; i++){
            if(k - arr[i][0] >= 0){
                answer += arr[i][1];
                k -= arr[i][0];
            } else if(k > 0){
                answer += k * arr[i][2];
                k = 0;
            } else{
                break;
            }
        }
        System.out.print(answer);

    }
}