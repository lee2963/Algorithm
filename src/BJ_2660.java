import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2660 {
    static boolean[][] map;
    static int n;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer> answer = new ArrayList<>();

    static class Node{
        int x;
        int cnt;

        public Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new boolean[n + 1][n + 1];

        while (true) {
            st = new StringTokenizer(br.readLine());

            int friend1 = Integer.parseInt(st.nextToken());
            int friend2 = Integer.parseInt(st.nextToken());

            if (friend1 == -1 && friend2 == -1) {
                break;
            }

            map[friend1][friend2] = true;
            map[friend2][friend1] = true;
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        answer.sort((o1, o2) -> o1 - o2);

        System.out.println(min + " " + answer.size());
        for (Integer person : answer) {
            System.out.print(person + " ");
        }
    }

    static void bfs(int cur) {

        boolean[] visited = new boolean[n + 1];
        visited[cur] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(cur, 0));

        int score = 0;
        while (!q.isEmpty()) {
            Node current = q.poll();

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && map[current.x][i]) {
                    q.add(new Node(i, current.cnt + 1));
                    visited[i] = true;
                }
            }
            score = Math.max(score, current.cnt);

        }

        if (min > score) {
            answer.clear();
            min = score;
            answer.add(cur);
        } else if (min == score) {
            answer.add(cur);
        }

    }
}
