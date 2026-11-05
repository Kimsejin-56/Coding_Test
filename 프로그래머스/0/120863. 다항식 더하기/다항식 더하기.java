class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int x = 0, n = 0;

        for (String s : polynomial.split(" \\+ ")) {
            if (s.contains("x")) {
                String coef = s.replace("x", "");
                x += coef.isEmpty() ? 1 : Integer.parseInt(coef);
            } else {
                n += Integer.parseInt(s);
            }
        }

        if (x > 0) {
            answer = (x == 1 ? "" : x) + "x";
        }

        if (n > 0) {
            answer += (x > 0 ? " + " : "") + n;
        }

        return answer;
    }
}