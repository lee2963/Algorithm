import java.util.*;

class Pg_12987 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int aIdx = 0;
        int bIdx = 0;

        for(int i = 0; i < A.length; i++){
            if(A[aIdx] >= B[bIdx]){
                bIdx++;
            } else{
                aIdx++;
                bIdx++;
                answer++;
            }
        }
        return answer;
    }
}