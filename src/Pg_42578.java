import java.util.*;

class Pg_42578 {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        if(map.size() == 1){
            for(Integer num : map.values()){
                answer *= num ;
            }
        } else{
            for(Integer num : map.values()){
                answer *= (num + 1);
            }
            answer -= 1;
        }

        return answer;
    }
}