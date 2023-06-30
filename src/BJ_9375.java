import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();

            for (int j = 0; j < m; j++) {
                String[] input = br.readLine().split(" ");
                if(map.containsKey(input[1])){
                    map.put(input[1], map.get(input[1]) + 1);
                } else{
                    map.put(input[1], 1);
                }
            }

            int answer = 1;
            if (map.size() == 1) {
                for (String s : map.keySet()) {
                    answer *= map.get(s);
                }
            } else{
                for (String s : map.keySet()) {
                    answer *= (map.get(s) + 1);
                }
                answer -= 1;
            }
            System.out.println(answer);
        }
    }
}
