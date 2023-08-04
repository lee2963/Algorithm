import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 0 ; i < n; i++){
            String str = br.readLine();
            boolean flag = true;
            Set<Character> set = new HashSet<>();
            set.add(str.charAt(0));
            for (int j = 1; j < str.length(); j++) {
                char ch = str.charAt(j);
                if(ch != str.charAt(j -1)){
                    if(set.contains(ch)){
                        flag = false;
                        break;
                    } else{
                        set.add(ch);
                    }
                }
            }
            if(flag){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
