import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        boolean sameChar = true;
        for (int i = 0; i < len / 2; i++) {

            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                System.out.println(len);
                return;
            }

            if (str.charAt(i) != str.charAt(i + 1)) {
                sameChar = false;
            }
        }

        if (!sameChar) {
            System.out.println(len - 1);
        } else{
            System.out.println(-1);
        }
    }
}
