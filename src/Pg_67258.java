import java.util.*;

class Pg_67258 {
    public int[] solution(String[] gems) {
        int[]answer = new int[2];
        int len = Integer.MAX_VALUE;

        Set<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }

        int num = set.size();
        Map<String, Integer> map = new HashMap<>();

        int left = 0;
        for(int right = 0; right < gems.length; right++){
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);

            while(map.get(gems[left]) > 1){
                map.put(gems[left], map.get(gems[left]) - 1);
                left++;
            }

            if(num == map.size() && len > (right - left)){
                len = right - left;
                answer[0] = left + 1;
                answer[1] = right + 1;
            }


        }
        return answer;
    }
}