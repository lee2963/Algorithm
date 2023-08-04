import java.util.*;
public class Pg_134240 {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder foodList = new StringBuilder();

        for(int i = 1; i < food.length; i++){
            int num = food[i] / 2;
            for(int j = 0; j < num; j++){
                foodList.append(i);
            }
        }

        answer = foodList.toString() + 0 + foodList.reverse().toString();
        return answer;
    }
}
