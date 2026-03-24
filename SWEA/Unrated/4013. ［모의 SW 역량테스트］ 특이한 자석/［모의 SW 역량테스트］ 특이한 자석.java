import java.util.*;
import java.io.FileInputStream;
class Point{
 	int x;
    int y;
    
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Solution
{
	static List<List<Integer>> arr;

    
    static int solution(List<Point> list){
        	int answer=0;
        	for(Point p : list){
				Set<Integer> set=new HashSet<>();

                for(int i=p.x-1; i<3; i++){
                   	if(arr.get(i).get(2) != arr.get(i+1).get(6)){
                        set.add(i);
                        set.add(i+1);
                    }else break;
                }
                
                for(int i=p.x-1; i>0; i--){
                   	if(arr.get(i).get(6) != arr.get(i-1).get(2)){
                        set.add(i);
                        set.add(i-1);
                    }else break;
                }
                
                int idx = p.x - 1;
                set.add(idx);  //자기는 항상 포함
                
                for(Integer i : set){
                 	if(p.y == 1){
                    	if(idx == i || idx+2==i || idx-2==i){
                         	int tmp=arr.get(i).get(7);
                            arr.get(i).remove(7);
                            arr.get(i).add(0, tmp);
                        } else {
                         	int tmp=arr.get(i).get(0);
                            arr.get(i).remove(0);
                            arr.get(i).add(tmp);
                        }
                	} else{
                        if(idx == i || idx+2==i || idx-2==i){
                         	int tmp=arr.get(i).get(0);
                            arr.get(i).remove(0);
                            arr.get(i).add(tmp);
                        } else {
                            int tmp=arr.get(i).get(7);
                            arr.get(i).remove(7);
                            arr.get(i).add(0, tmp);
                        }
                    }
                }
           }
        
        	for(int i=0; i<4; i++){
            	if(arr.get(i).get(0)==1){
                    answer+=(int)Math.pow(2,i);
                }
            }
        
        	return answer;
    }
    
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int k=sc.nextInt();
            
           	arr=new ArrayList<>();
            for(int i=0; i<4; i++){
                arr.add(new ArrayList<>());
             	for(int j=0; j<8; j++){
                 	   arr.get(i).add(sc.nextInt());
                }
            }
			List<Point> list=new ArrayList<>();
            for(int i=0; i<k; i++) list.add(new Point(sc.nextInt(), sc.nextInt()));

            System.out.println("#"+test_case+" "+solution(list));
		}
	}
}