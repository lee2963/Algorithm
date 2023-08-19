import java.util.*;

class Pg_12927 {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < works.length; i++){
            pq.add(works[i]);
        }

        for(int i = 0; i < n; i++){
            int num = 0;
            if(!pq.isEmpty()){
                num = pq.poll() - 1;
            } else{
                return 0;
            }


            if(num > 0)
                pq.add(num);
        }

        while(!pq.isEmpty()){
            int num = pq.poll();
            answer += num * num;
        }

        return answer;
    }
}