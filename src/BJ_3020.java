import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] bot = new int[h + 1];
        int[] top = new int[h + 1];

        for (int i = 0; i < n / 2; i++) {
            bot[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }

        int[] botSum = new int[h + 1];
        int[] topSum = new int[h + 1];

        for (int i = 1; i <= h; i++) {
            botSum[i] = botSum[i - 1] + bot[i];
            topSum[i] = topSum[i - 1] + top[i];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= h; i++) {
            int broken = 0;

            broken += botSum[h] - botSum[i - 1];
            broken += topSum[h] - topSum[h - i];

            if(min > broken){
                min = broken;
                cnt = 1;
            } else if(min == broken){
                cnt++;
            }
        }

        System.out.println(min +" " + cnt);
    }
}
