import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] alpha = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            alpha[ch - 'A']++;
        }

        int center = -1;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (alpha[i] > 0) {
                if (alpha[i] % 2 == 0) {
                    for (int j = 0; j < alpha[i] / 2; j++) {
                        answer.append((char) ('A' + i));
                    }
                } else {
                    if (center != -1) {
                        System.out.println("I'm Sorry Hansoo");
                        return;
                    } else{
                        center = i;

                        alpha[i]--;

                        if (alpha[i] > 0) {
                            for (int j = 0; j < alpha[i]/ 2; j++) {
                                answer.append((char)(i + 'A'));
                            }
                        }
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder(answer);
        if (center != -1) {
            answer.append((char) ('A' + center));
        }

        System.out.println(result.append(answer.reverse()));

    }
}
