import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BJ_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int idx = input.indexOf('.');

            String file = input.substring(idx + 1);
            if (map.containsKey(file)) {
                map.put(file, map.get(file) + 1);
            } else{
                map.put(file, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
