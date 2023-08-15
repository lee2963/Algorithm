class Pg_12938 {
    public int[] solution(int n, int s) {
        if(n > s) {
            return new int[] {-1};
        }
        int[] answer = new int[n];
        if(s % n ==0) {        //나눠지는 경우
            for(int i = 0 ; i < n; i++) {
                answer[i] = s / n;
            }

        }else {
            int rem = s % n;
            int po = n - rem;

            for(int i = 0; i < po; i++) {
                answer[i] = s / n;
            }
            for(int i = po; i < n; i++) {
                answer[i] = s / n +1;
            }
        }
        return answer;
    }
}