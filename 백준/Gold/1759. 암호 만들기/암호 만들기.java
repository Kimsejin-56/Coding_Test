import java.util.*;

public class Main {
    static String[] str, pm;
    static Set<String> answer=new HashSet<>();
    static int l, c;
    static int[][] dy=new int[1000][1000];

    static void dfs(int L, int s) {
        if(L==l){
            int count=0;
            for (int i = 0; i < l; i++) {
                if(pm[i].equals("a") || pm[i].equals("e") || pm[i].equals("i") ||
                        pm[i].equals("o") || pm[i].equals("u")){
                    count++;
                }
            }

            if(count<1) return;
            if(l-count<2) return;
            String tmp="";
            for (int i = 0; i < l; i++) tmp+=pm[i];
            answer.add(tmp);
            return;
        }
        for (int i = s; i < c; i++) {
            pm[L]=str[i];
            dfs(L+1, i+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        str = new String[c];

        for (int i = 0; i < c; i++) {
            str[i] = sc.next();
        }

        Arrays.sort(str);
        pm = new String[l];
        dfs(0, 0);

        ArrayList<String> list=new ArrayList<>(answer);
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}