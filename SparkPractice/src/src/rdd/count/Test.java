package src.rdd.count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Pair {
    char c;
    int val;

    Pair(char c, int val) {
	this.c = c;
	this.val = val;
    }
}
public class Test {

    public static void main(String[] args) {
	int A = 0, B = 1, C = 8;
	System.out.println(solution(A, B, C));
	;
    }
        

        public static String solution(int A, int B, int C) {
        
             Map<Character, Integer> map = new HashMap<>();
            map.put('a', A);
            map.put('b', B);
            map.put('c', C);
	// System.out.println((a, b) -> ((b.val != a.val) && (b.val > a.val)) ? b.val -
	// a.val : a.c - b.c));
	PriorityQueue<Pair> 
	    pq = new PriorityQueue<>(
		((a, b) -> (b.val != a.val) ? b.val - a.val : a.c - b.c));
	if (A == 0)
	    pq = new PriorityQueue<>(((a, b) -> (a.val != 0) ? b.val : a.c - b.c));
            for(char c: map.keySet())
                pq.offer(new Pair(c, map.get(c)));
            
            StringBuilder sb = new StringBuilder();
            while(!pq.isEmpty())
            {
                int i = 0;
                List<Pair> tempList = new ArrayList<>();
                while(i<3&&!pq.isEmpty()) //we are not allowed to poll a char twice in a cycel (len=3 or 4)
                {
                    Pair p = pq.poll();
                    if(p.val>=2) //main diff from rearrage string k distance apart
                    {
                        sb.append(p.c);
                        sb.append(p.c);
                        p.val--;
                        p.val--;
                        i++;
                        i++;
                    }else{
                        sb.append(p.c);
                        p.val--;
                        i++;
                    }
                    if(p.val!=0) tempList.add(p); //when p.val==0, remove it
                }
                //3 or 4 are both fine here, but it cannot be less than 3
                if(i<3&&tempList.size()>0) return ""; //if i<k, but it's the last cycle, it's fine
                
                for(Pair p:tempList)
                    pq.offer(p);   
            }
            return sb.toString();    
        }
    }

