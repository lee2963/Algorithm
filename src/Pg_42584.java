import java.util.*;

class Pg_42584 {
    public int[] solution(int[] prices) {
        int len = prices.length;
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int[] answer = new int[prices.length];

        for(int i = 1; i < len; i++){
            while(true){

                if(!s.isEmpty() && prices[s.peek()] > prices[i]){
                    int idx = s.pop();
                    answer[idx] = i - idx;
                } else{
                    s.push(i);
                    break;
                }
            }
        }

        while(!s.isEmpty()){
            int idx = s.pop();

            answer[idx] = len - idx - 1;
        }

        return answer;
    }
}