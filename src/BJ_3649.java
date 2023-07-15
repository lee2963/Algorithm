import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_3649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        while((s = br.readLine()) != null) {
            int hole = Integer.parseInt(s) * 10000000;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int left = 0, right = n - 1;
            boolean chk = true;
            while (left < right) {
                if (arr[left] + arr[right] == hole) {
                    System.out.println("yes " + arr[left] + " " + arr[right]);
                    chk = false;
                    break;
                }

                if (arr[left] + arr[right] > hole) {
                    right--;
                } else {
                    left++;
                }
            }
            if(chk)
                System.out.println("danger");
        }
    }
}
