import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        while (left < right) {

            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < min){
                min = Math.abs(arr[left] + arr[right]);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if (sum >= 0) {
                right--;
            } else{
                left++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
