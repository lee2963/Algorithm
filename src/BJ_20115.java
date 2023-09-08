import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BJ_20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];

        double max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Double.parseDouble(st.nextToken());

            max = Math.max(arr[i], max);
        }

        double sum = max;
        for(int i = 0; i < n; i++){
            if(arr[i] == max) continue;

            sum += arr[i] / 2;

        }

        System.out.println(sum);
    }
}
