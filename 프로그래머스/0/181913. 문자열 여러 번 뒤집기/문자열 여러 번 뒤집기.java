class Solution {
    public String solution(String my_string, int[][] queries) {
        String result = my_string;
    
        for(int i=0; i<queries.length; i++){
            int [] query = queries[i];
            int n1 = query[0];
            int n2 = query[1];
            int idx = 0;
            String temp = "";
            String answer = "";
            
            for(int j=n1; j<=n2; j++){
                temp += result.charAt(j); 
            }
 
            char [] arr = new char[temp.length()];
            int last = temp.length() - 1;
            
            
            for(int j=0; j<temp.length(); j++){
                arr[last--] = temp.charAt(j);
            }
            
            for(int j=0; j<result.length(); j++){
                if(j < query[0] || j > query[1]){
                     answer += result.charAt(j);
                    continue;
                }
                
                answer += arr[idx++];
            }
            result = answer;
        }
        
        return result;
    }
}