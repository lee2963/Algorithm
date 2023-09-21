import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_6987 {
    static int[][] result;
    static int[][] match;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        answer = new int[4];
        match = new int[15][2];
        int idx = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                match[idx][0] = i;
                match[idx][1] = j;
                idx++;
            }
        }

        for (int i = 0; i < 4; i++) {
            result = new int[6][3];

            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean chk = false;
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    result[j][k] = Integer.parseInt(st.nextToken());
                }

                if (result[j][0] + result[j][1] + result[j][2] != 5) {
                    chk = true;
                }
            }

            if(!chk) dfs(i, 0);
        }


        for (int i = 0; i < 4; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    static void dfs(int idx, int cnt) {

        if(cnt == 15){
            answer[idx] = 1;
            return;
        }

        int team1 = match[cnt][0];
        int team2 = match[cnt][1];

        if(result[team1][0] >= 1 && result[team2][2] >= 1){
            result[team1][0]--;
            result[team2][2]--;
            dfs(idx, cnt + 1);
            result[team1][0]++;
            result[team2][2]++;
        }

        if(result[team1][1] >= 1 && result[team2][1] >= 1){
            result[team1][1]--;
            result[team2][1]--;
            dfs(idx, cnt + 1);
            result[team1][1]++;
            result[team2][1]++;

        }

        if (result[team1][2] >= 1 && result[team2][0] >= 1) {
            result[team1][2]--;
            result[team2][0]--;
            dfs(idx, cnt + 1);
            result[team1][2]++;
            result[team2][0]++;
        }

    }
}
