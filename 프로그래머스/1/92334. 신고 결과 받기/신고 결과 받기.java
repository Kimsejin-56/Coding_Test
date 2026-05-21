import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer=new int[id_list.length];
        Map<String, Set<String>> map=new HashMap<>();
        Map<String, Integer> ban=new HashMap<>();
        List<String> list=new ArrayList<>();
        
        for(String str : report){
            String[] arr=str.split(" ");
            map.putIfAbsent(arr[0], new HashSet<>());
            map.get(arr[0]).add(arr[1]);
        }
        
        for(String key : map.keySet()){
            for(String s : map.get(key)){
                ban.put(s, ban.getOrDefault(s, 0)+1);
            }
        }
        
        for(String key : ban.keySet()){
            if(ban.get(key) >= k) list.add(key);
        }
        
        for(int i=0; i<id_list.length; i++){
            String str=id_list[i];
            for(String s : list){
                if(map.get(str) == null) continue;
                if(map.get(str).contains(s)) answer[i]++;
            }
        }
        
        return answer;
    }
}