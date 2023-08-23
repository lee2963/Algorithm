import java.util.*;

class Pg_43164 {
    static boolean[] visited;
    static List<String> answer = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        dfs("ICN", tickets, "ICN", 0);

        Collections.sort(answer);

        return answer.get(0).split(" ");
    }

    static void dfs(String cur, String[][] tickets, String route, int cnt){
        if(cnt == tickets.length){
            answer.add(route);
            return;
        }

        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(cur)){
                visited[i] = true;
                dfs(tickets[i][1], tickets, route + " " + tickets[i][1], cnt + 1);
                visited[i] = false;
            }
        }
    }
}
