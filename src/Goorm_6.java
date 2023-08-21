import java.io.*;
import java.util.*;

class Goorm_6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 1; i < str.length() - 1; i++){
            for(int j = i + 1; j <str.length(); j++){

                if(!set.contains(str.substring(0, i))){
                    list.add(str.substring(0, i));
                    set.add(str.substring(0, i));
                }
                if(!set.contains(str.substring(i, j))){
                    list.add(str.substring(i, j));
                    set.add(str.substring(i, j));
                }
                if(!set.contains(str.substring(j))){
                    list.add(str.substring(j));
                    set.add(str.substring(j));
                }
            }
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            map.put(list.get(i), i + 1);
        }

        int max = 0;
        for(int i = 1; i < str.length() - 1; i++){
            for(int j = i + 1; j <str.length(); j++){
                int score = 0;

                score += map.get(str.substring(0, i));
                score += map.get(str.substring(i, j));
                score += map.get(str.substring(j));

                max = Math.max(score, max);
            }
        }

        System.out.print(max);
    }
}