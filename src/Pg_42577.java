import java.util.*;

class Pg_42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int len = phone_book.length;

        Set<String> set = new HashSet<>();
        for(int i = 0; i < len; i++){
            set.add(phone_book[i]);
        }

        for(int i = 0; i < len; i++){
            for(int j = 1; j < phone_book[i].length(); j++){
                if(set.contains(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }
        return answer;
    }
}