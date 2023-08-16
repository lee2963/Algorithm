class Pg_42883 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int max = 0;
        int idx = 0;

        for(int i = idx; i < number.length() - k; i++){
            max = 0;
            for(int j = idx; j <= k + i; j++){
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}