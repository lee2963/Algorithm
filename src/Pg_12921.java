class Pg_12921 {
    public int solution(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n + 1];
        isPrime[0] = true;
        isPrime[1] = true;

        for(int i = 2; i * i <= n; i++){
            if(!isPrime[i]){
                for(int j = i * 2; j <= n; j += i){
                    isPrime[j] = true;
                }
            }
        }

        for(int i = 2; i <= n; i++){
            if(!isPrime[i]){
                answer++;
            }
        }
        return answer;
    }
}