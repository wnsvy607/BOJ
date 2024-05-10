import java.util.*;

class Solution {
    
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        
        Map<Character, Character> need = new HashMap<>();
        for(int i = 1; i < skill.length();i++) {
            need.put(skill.charAt(i), skill.charAt(i - 1));
        }
        
        
        for(String trees : skill_trees) {
            Set<Character> skillSet = new HashSet<>();
            boolean flag = true;
            for(int i = 0; i < trees.length(); i++) {
                char sk = trees.charAt(i);
                if(need.containsKey(sk) && !skillSet.contains(need.get(sk))) {
                    flag = false;
                    break;
                }
                skillSet.add(sk);
            } 
            if(flag)
                count++;
        } 
        
        return count;
    }
}