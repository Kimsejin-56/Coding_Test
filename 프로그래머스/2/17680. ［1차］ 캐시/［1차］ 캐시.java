import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Map<String, Integer> cache = new HashMap<>();
        int time=0;
        
        for(int i=0; i<cities.length; i++){
            String city=cities[i].toLowerCase();
            if(cache.containsKey(city)){
                time+=1;
                cache.put(city, i);
                continue;
            }
            
            if(cache.size()<cacheSize){
                cache.put(city, i);
                time+=5;
                continue;
            }
            
            int min=Integer.MAX_VALUE;
            for(String key : cache.keySet()){
                min=Math.min(min, cache.get(key));
            }
            
            for(String key : cache.keySet()){
                if(min==cache.get(key)){
                    cache.remove(key);
                    cache.put(city, i);
                    break;
                }
            }
            time+=5;
        }
        
        return time;
    }
}