import java.util.*;

class Pg_42579 {
    static class Song{
        int play;
        int idx;

        public Song( int play, int idx){
            this.play = play;
            this.idx = idx;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < plays.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Song> result = new ArrayList<>();
        List<String> seq = new ArrayList<>(map.keySet());
        Collections.sort(seq, (o1, o2) -> map.get(o2) - map.get(o1));

        for(String s : seq) {
            List<Song> list = new ArrayList<>();
            for(int i = 0; i < genres.length; i++){
                if(genres[i].equals(s)){
                    list.add(new Song(plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) ->{
                if(o1.play == o2.play)
                    return o1.idx - o2.idx;

                return o2.play - o1.play;
            });

            result.add(list.get(0));
            if(list.size() > 1)
                result.add(list.get(1));
        }

        int[] answer = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i).idx;
        }

        return answer;
    }
}