import java.util.*;

//9:09
class Point implements Comparable<Point>{
    int num, play;
    
    public Point(int num, int play){
        this.num=num;
        this.play=play;
    }
    
    public int compareTo(Point p){
        if(this.play==p.play) return this.num-p.num;
        return p.play-this.play;
    }
    
    public String toString(){
        return num+" "+play;
    }
}

class Music{
    String genre;
    int sum;
    
    public Music(String genre, int sum){
        this.genre=genre;
        this.sum=sum;
    }
    
    public String toString(){
        return genre+" "+sum;
    }
}

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, List<Point>> music=new HashMap<>();
        List<Music> order=new ArrayList<>();
        
        for(int i=0; i<genres.length; i++){
            String genre=genres[i];
            music.putIfAbsent(genre, new ArrayList<>());
            
            music.get(genre).add(new Point(i, plays[i]));
        }
        
        for(String key : music.keySet()){
            int sum=0;
            List<Point> idxs=music.get(key);
            
            for(Point p : idxs){
                sum+=p.play;
            }
            
            order.add(new Music(key, sum));
        }
        
        order.sort((a, b) -> b.sum-a.sum);
        
        for(Music m : order){
            List<Point> list=music.get(m.genre);
            
            Collections.sort(list);
            
            if(list.size()>=2){
                for(int i=0; i<2; i++){
                    answer.add(list.get(i).num);
                }
            }else {
                answer.add(list.get(0).num);
            }
        }
        
        return answer;
    }
}