import java.util.*;

class Pg_181188 {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        answer++;
        int end = targets[0][1];
        for(int i = 1; i < targets.length; i++){

            if(targets[i][0] >= end){

                end = targets[i][1];
                answer++;
            }
        }

        return answer;
    }
}
