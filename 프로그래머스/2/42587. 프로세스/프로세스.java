import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q=new ArrayDeque<>();
        Map<Integer, Integer> cnt=new HashMap<>();
        List<Integer> sort=new ArrayList<>();
        int[] arr=new int[priorities.length];

        for(int i=0; i<priorities.length; i++){
            cnt.put(priorities[i], cnt.getOrDefault(priorities[i], 0)+1);
            q.offer(i);
            if(!sort.contains(priorities[i])) sort.add(priorities[i]);
        }

        Collections.sort(sort, Collections.reverseOrder());

        while(!q.isEmpty()){
            int name=q.poll();
            int cur=priorities[name];
            int max=sort.get(0);
            if(cur==max) {
                answer++;
                arr[name]=answer;
                cnt.put(max, cnt.get(max)-1);
                if(cnt.get(max)==0){
                    sort.remove(0);
                }
            }else q.offer(name);
        }

        return arr[location];
    }
}