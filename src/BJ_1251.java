import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<String> list = new ArrayList<>();

        for(int i = 1; i < str.length() - 2; i++){
            StringBuilder first = new StringBuilder(str.substring(0, i));
            first.reverse();
            for(int j = str.length() - 1; j >= i + 1; j--){
                StringBuilder second = new StringBuilder(str.substring(i, j));
                StringBuilder last = new StringBuilder(str.substring(j));

                String s = first.toString() + second.reverse() + last.reverse();
                list.add(s);
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}
