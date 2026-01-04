import java.util.*;
import java.math.*;

class Solution {
    public String solution(String a, String b) {
        String answer = "";
        
        BigInteger num1 = new BigInteger(a);
        BigInteger num2 = new BigInteger(b);
        
        BigInteger result = num1.add(num2);
            
        answer = String.valueOf(result);
        
        return answer;
    }
}