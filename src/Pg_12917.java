import java.util.*;
public class Pg_12917 {
    public String solution(String s) {
        String[] str = s.split("");

        Arrays.sort(str, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
