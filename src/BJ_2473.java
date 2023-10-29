import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Long> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(list);

        long[] answer = new long[3];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                long sum = list.get(i) + list.get(left) + list.get(right);

                if(min > Math.abs(sum)){
                    min = Math.abs(sum);
                    answer[0] = list.get(i);
                    answer[1] = list.get(left);
                    answer[2] = list.get(right);
                }

                if(sum > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }

        Arrays.sort(answer);

        for (int i = 0; i < 3; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
