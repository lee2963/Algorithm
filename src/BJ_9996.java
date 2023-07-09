import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BJ_9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        String[] patternArr = pattern.split("\\*");

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if (patternArr[0].length() + patternArr[1].length() > str.length()) {
                System.out.println("NE");
                continue;
            }

            String front = str.substring(0, patternArr[0].length());
            String back = str.substring(str.length() - patternArr[1].length());


            if (front.equals(patternArr[0]) && back.equals(patternArr[1])) {
                System.out.println("DA");
            } else{
                System.out.println("NE");
            }
        }
    }
}
