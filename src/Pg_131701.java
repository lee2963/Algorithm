import java.util.*;

class Pg_131701 {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[elements.length * 2];

        for(int i = 0; i < elements.length; i++){
            arr[i] = arr[i + elements.length] = elements[i];
        }

        for(int i = 0; i < elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                int num = 0;
                for(int m = j; m <= j + i; m++){
                    num += arr[m];
                }
                set.add(num);
            }
        }

        return set.size();
    }
}