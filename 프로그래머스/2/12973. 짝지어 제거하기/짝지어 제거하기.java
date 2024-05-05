import java.util.*;

class Solution
{
    public int solution(String s)
    {
        
        Deque<Character> dq = new ArrayDeque<>();
        dq.addFirst(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!dq.isEmpty() && dq.peekFirst() == ch)
                dq.pollFirst();
            else
                dq.addFirst(ch);
        }
        
        if(dq.isEmpty())
            return 1;
        return 0;
    }
}